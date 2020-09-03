package com.backend.tienda.controllers;


import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.tienda.entity.CuentaEmpresa;
import com.backend.tienda.entity.Cuenta_Usuario;
import com.backend.tienda.entity.Cuenta_repartidor;
import com.backend.tienda.entity.EmpresaOficial;
import com.backend.tienda.entity.Repartidor;
import com.backend.tienda.entity.Roles;
import com.backend.tienda.entity.Usuario;
import com.backend.tienda.entity.Usuario_general;
import com.backend.tienda.entity.UsuarioInfo;
import com.backend.tienda.models.ERole;
import com.backend.tienda.models.Role;
import com.backend.tienda.models.User;
import com.backend.tienda.payload.request.LoginRequest;
import com.backend.tienda.payload.request.SignupRequest;
import com.backend.tienda.payload.response.JwtResponse;
import com.backend.tienda.payload.response.MessageResponse;
import com.backend.tienda.repositorys.RoleRepository;
import com.backend.tienda.repositorys.UserRepository;
import com.backend.tienda.security.jwt.JwtUtils;
import com.backend.tienda.security.services.AuthenticationUserService;
import com.backend.tienda.security.services.UserDetailsImpl;
import com.backend.tienda.service.CuentaEmpresaService;
import com.backend.tienda.service.Cuenta_UsuarioService;
import com.backend.tienda.service.Cuenta_repartidorService;
import com.backend.tienda.service.EmpresaOficialService;
import com.backend.tienda.service.RepartidorService;
import com.backend.tienda.service.UsuarioService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	AuthenticationUserService authenticationUserService;
	
	@Autowired
	UsuarioService usuarioService;

	
	@Autowired
	Cuenta_UsuarioService cuenta_UsuarioService;
	
	@Autowired
	EmpresaOficialService empresaOficialService;
	
	@Autowired
	CuentaEmpresaService cuentaEmpresaService;
	
	
	@Autowired
	Cuenta_repartidorService cuenta_repartidorService;
	
	
	@Autowired
	RepartidorService repartidorService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		
		JwtResponse jwt=authenticationUserService.jwtToken(loginRequest.getUsername(),loginRequest.getPassword());
		
		return ResponseEntity.ok(jwt);
	}
	
	

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		

		
		if (userRepository.existsByNombre(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByCorreo(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		Usuario_general user = new Usuario_general(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 "nada",
							 "nada",
							 "nada");

		Set<String> strRoles = signUpRequest.getRole();
		Set<Roles> roles = new HashSet<>();

		if (strRoles == null) {
			Roles userRole = roleRepository.findByNombre(ERole.ROLE_CLIENTE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "cliente":
					Roles cliRole = roleRepository.findByNombre(ERole.ROLE_CLIENTE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(cliRole);

					break;
				case "empresa":
					Roles empRole = roleRepository.findByNombre(ERole.ROLE_EMPRESA_ASOCIADA)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(empRole);

					break;
				case "motorizado":
					Roles motoRole = roleRepository.findByNombre(ERole.ROLE_MOTORIZADO)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(motoRole);
					break;
						
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	
	
	//REGISTRARSE Y LOGEARSE CON UNA CUENTA DE FACEBOOK O GOOGLE
	@PostMapping("/signupProvider")
	public ResponseEntity<?> registerUserProvider(@RequestBody UsuarioInfo usuarioInfo) {
				
		Usuario_general usuario_general=null;
		
		Usuario usuario=null;
		
		
		String default_password="provedor";
		

		if (userRepository.existsByCorreo(usuarioInfo.getCorreo().trim())) {
			
			JwtResponse jwt=authenticationUserService.jwtToken(usuarioInfo.getCorreo(),default_password);
			
			return ResponseEntity.ok(jwt);
		}

		// Create new user's account
		Usuario_general user = new Usuario_general(usuarioInfo.getNombre(), 
							usuarioInfo.getCorreo().trim(),
							 encoder.encode("provedor"),
							 usuarioInfo.getApellido(),
							 usuarioInfo.getCelular(),
							 usuarioInfo.getFoto());
		
		

		
		
		Set<Roles> roles = new HashSet<>();
		
		Roles cliRole = roleRepository.findByNombre(ERole.ROLE_CLIENTE)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(cliRole);
		
	
		user.setRoles(roles);
		//CREANDO EN LA TABLA DE USUARIO_GENERAL
		usuario_general=userRepository.save(user);
		
		
		
		//CREANDO EN LA TABLA DE USUARIO 
		usuario=new Usuario();
		usuario.setIdusuario(0);
		usuario.setIdusuariogeneral(usuario_general.getIdusuariogeneral());
		
		usuario=usuarioService.guardarUsuario(usuario);
	
		
		
		
		//CREANDO EN LA TABLA DE CUENTA_USUARIO
		Timestamp time=new Timestamp(System.currentTimeMillis());

		Cuenta_Usuario createCuenta_Usuario= new Cuenta_Usuario();
		createCuenta_Usuario.setIdcuentausuario(0);
		createCuenta_Usuario.setActiva(true);
		createCuenta_Usuario.setFecharegistro(time);
		createCuenta_Usuario.setIdtipocuenta(1);
		createCuenta_Usuario.setIdusuario(usuario.getIdusuario());
		
		cuenta_UsuarioService.saveCuenta_Usuario(createCuenta_Usuario);
		
		JwtResponse jwt=authenticationUserService.jwtToken(usuarioInfo.getCorreo(),default_password);
		
		return ResponseEntity.ok(jwt);

	}
	
	
	//REGISTRARSE Y LOGEARSE CON UNA CUENTA DE EMPRESA
	@PostMapping("/signupEmpresa")
	public ResponseEntity<?> registerUserEmpresa(@RequestBody UsuarioInfo usuarioInfo) {
				
		Usuario_general usuario_general=null;
		
		EmpresaOficial empresaOficial=null;
		
			

		/*if (userRepository.existsByCorreo(usuarioInfo.getCorreo().trim())) {
			
			JwtResponse jwt=authenticationUserService.jwtToken(usuarioInfo.getCorreo(),usuarioInfo.getContrasena());
			
			return ResponseEntity.ok(jwt);
		}*/

		// Create new user's account
		Usuario_general user = new Usuario_general(usuarioInfo.getNombre(), 
							usuarioInfo.getCorreo().trim(),
							 encoder.encode(usuarioInfo.getContrasena()),
							 usuarioInfo.getApellido(),
							 usuarioInfo.getCelular(),
							 usuarioInfo.getFoto());
		
		

		
		
		Set<Roles> roles = new HashSet<>();
		
		Roles cliRole = roleRepository.findByNombre(ERole.ROLE_EMPRESA_ASOCIADA)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(cliRole);
		
	
		user.setRoles(roles);
		//CREANDO EN LA TABLA DE USUARIO_GENERAL
		usuario_general=userRepository.save(user);
		
		
		System.out.println(usuario_general.getApellido()+" / "+usuario_general.getIdusuariogeneral());
		
		
		//CREANDO EN LA TABLA DE EMPRESA 
		
		empresaOficial=new EmpresaOficial();
		
	
		empresaOficial.setIdsubcategoriaempresa(2);
		empresaOficial.setIdusuariogeneral(usuario_general.getIdusuariogeneral());
		empresaOficial.setNombre_empresa("");
		empresaOficial.setNombredueno_empresa("");
		empresaOficial.setDireccion_empresa("");
		empresaOficial.setRuc_empresa("");
		empresaOficial.setTelefono_empresa("");
		empresaOficial.setCelular_empresa("");
		empresaOficial.setDescripcion_empresa("");
		empresaOficial.setUrlfoto_empresa("");
		empresaOficial.setNombre_empresa("");
		empresaOficial.setPorcentaje_popularidad(0);
		empresaOficial.setIddistrito(1);
		
		empresaOficial=empresaOficialService.guardarEmpresaOficial(empresaOficial);
		
		
		//CREANDO EN LA TABLA DE CUENTA_USUARIO
		Timestamp time=new Timestamp(System.currentTimeMillis());

		CuentaEmpresa createCuenta_Empresa= new CuentaEmpresa();
		createCuenta_Empresa.setIdtipocuenta(1);
		createCuenta_Empresa.setCuentaactiva(true);
		createCuenta_Empresa.setFecha_registrocuenta(time);
		createCuenta_Empresa.setFecha_vencimiento(time);
		createCuenta_Empresa.setMontoabonado(100);
		createCuenta_Empresa.setDetallecuenta("");
		createCuenta_Empresa.setIdempresa(empresaOficial.getIdempresa());
		createCuenta_Empresa.setIdtarifa(2);
		createCuenta_Empresa.setMarketplace(true);
		createCuenta_Empresa.setSocio(true);
		
		cuentaEmpresaService.insertarCuentaEmpresa(createCuenta_Empresa);
		
		JwtResponse jwt=authenticationUserService.jwtToken(usuarioInfo.getCorreo(),usuarioInfo.getContrasena());
		
		return ResponseEntity.ok(jwt);

	}
	
	
	//REGISTRARSE Y LOGEARSE CON UNA CUENTA DE EMPRESA
		@PostMapping("/signupRepartidor")
		public ResponseEntity<?> registerUserRepartidor(@RequestBody UsuarioInfo usuarioInfo) {
					
			Usuario_general usuario_general=null;
			
			Repartidor repartidor=null;
				

			/*if (userRepository.existsByCorreo(usuarioInfo.getCorreo().trim())) {
				
				JwtResponse jwt=authenticationUserService.jwtToken(usuarioInfo.getCorreo(),usuarioInfo.getContrasena());
				
				return ResponseEntity.ok(jwt);
			}*/

			// Create new user's account
			Usuario_general user = new Usuario_general(usuarioInfo.getNombre(), 
								usuarioInfo.getCorreo().trim(),
								 encoder.encode(usuarioInfo.getContrasena()),
								 usuarioInfo.getApellido(),
								 usuarioInfo.getCelular(),
								 usuarioInfo.getFoto());
			
			

			
			
			Set<Roles> roles = new HashSet<>();
			
			Roles cliRole = roleRepository.findByNombre(ERole.ROLE_MOTORIZADO)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(cliRole);
			
		
			user.setRoles(roles);
			//CREANDO EN LA TABLA DE USUARIO_GENERAL
			usuario_general=userRepository.save(user);
			
			
			System.out.println(usuario_general.getApellido()+" / "+usuario_general.getIdusuariogeneral());
			
			
			//CREANDO EN LA TABLA DE REPARTIDOR
			
			repartidor=new Repartidor();
		
			repartidor.setIdrepartidor(0);
			repartidor.setIdusuariogeneral(usuario_general.getIdusuariogeneral());
			
			repartidor=repartidorService.guardarRepartidor(repartidor);
			
			
			//CREANDO EN LA TABLA DE CUENTA_REPARTIDOR
			Timestamp time=new Timestamp(System.currentTimeMillis());

			Cuenta_repartidor cuenta_repartidor=new Cuenta_repartidor();
			
			cuenta_repartidor.setIdcuentarepartidor(0);
			cuenta_repartidor.setActiva(true);
			cuenta_repartidor.setIdtipocuenta(1);
			cuenta_repartidor.setFecharegistro(time);
			cuenta_repartidor.setFechavencimiento(time);
			cuenta_repartidor.setIdrepartidor(repartidor.getIdrepartidor());
			cuenta_repartidor.setIdtarifa(2);
			cuenta_repartidor.setMontoabonado(200);
			
			cuenta_repartidorService.guardarCuenta_repartidor(cuenta_repartidor);
			
			JwtResponse jwt=authenticationUserService.jwtToken(usuarioInfo.getCorreo(),usuarioInfo.getContrasena());
			
			return ResponseEntity.ok(jwt);

		}
	
}
