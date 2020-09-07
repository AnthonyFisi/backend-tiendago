package com.backend.tienda.firebase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import java.util.concurrent.ExecutionException;

@Service
public class DeliveryService {
	
	public static final String COL_NAME="UsuariosDelivery";
	
	@Autowired
	FBInitialize db;
	
	
	public void updateData() {
		CollectionReference documentReference =db.getFirebase().collection(COL_NAME);
		documentReference.document("1").update("location", "-12.174714,-76.935345");
		
	}

	
	
	public List<Delivery> listaDeliveryAble(boolean disponible) throws InterruptedException, ExecutionException{
		
		List<Delivery> listAble=new ArrayList<>();
		
		
	        CollectionReference documentReference =db.getFirebase().collection(COL_NAME);
	        
	        
	        ApiFuture<QuerySnapshot> future = documentReference.whereEqualTo("disponible",true)
	        												   .whereEqualTo("cuentaActivada", true)
	        												   .whereEqualTo("online", true)
	        												   .get();
	        //documentReference.document(childPath)
	        
	        for(DocumentSnapshot doc:future.get().getDocuments()) {
	        	Delivery delivery=doc.toObject(Delivery.class);
	        	listAble.add(delivery);
	        }
	        
	       
		return listAble;
	}
	
	
	
	public void loadData(int data) throws InterruptedException, ExecutionException {
		CollectionReference cities = db.getFirebase().collection(COL_NAME);
		List<ApiFuture<WriteResult>> futures = new ArrayList<>();
	
		if(data==1) {
		
		futures.add(cities.document(String.valueOf(9)).set(new Delivery(true,4,4,9,"-12.177294,-76.937029","nombre4",true,true,3,9.369628185951012,5.439807348694531,3.25243441962278)));
		/*futures.add(cities.document(String.valueOf(5)).set(new Delivery(true,5,5,5, "-12.175260,-76.938038"  ,"nombre" ,true,true,1,3.168915058265533,1.5951419233282857,5.036104420500885)));
		futures.add(cities.document(String.valueOf(6)).set(new Delivery(true,6,6,6, "-12.175385,-76.936965"  ,"nombre" ,true,true,10,4.893497735633812,4.50533757658042,5.266144400342978)));
		futures.add(cities.document(String.valueOf(7)).set(new Delivery(true,7,7,7, "-12.176036,-76.936289"  ,"nombre" ,true,true,5,10.232380922921292,2.9733362017640133,3.566531878071951)));
		futures.add(cities.document(String.valueOf(8)).set(new Delivery(true,8,8,8, "-12.174463,-76.937147"  ,"nombre" ,true,true,4,5.217868200079761,5.352615181650157,5.834534381479234)));
		futures.add(cities.document(String.valueOf(9)).set(new Delivery(true,9,9,9, "-12.175386,-76.936375"  ,"nombre" ,true,true,3,8.648605892280372,3.3211110559999515,5.961932628764396)));
		futures.add(cities.document(String.valueOf(10)).set(new Delivery(true,10,10,10, "-12.175344,-76.935731"  ,"nombre" ,true,true,1,14.780736676995572,3.457110539063603,4.021844112948569)));
		futures.add(cities.document(String.valueOf(11)).set(new Delivery(true,11,11,11, "-12.174001,-76.936375"  ,"nombre" ,true,true,4,12.23339343618546,2.559958268697005,4.392267502536451)));
		futures.add(cities.document(String.valueOf(12)).set(new Delivery(true,12,12,12, "-12.175008,-76.935752"  ,"nombre" ,true,true,8,13.930780066433412,2.134435162560476,5.061614314118661)));
		futures.add(cities.document(String.valueOf(13)).set(new Delivery(true,13,13,13, "-12.175302,-76.935602"  ,"nombre" ,true,true,6,11.472402400064954,4.884418503367678,1.6710696802232607)));
		futures.add(cities.document(String.valueOf(14)).set(new Delivery(true,14,14,14, "-12.173729,-76.936010"  ,"nombre" ,true,true,4,1.361111778337393,4.894444107701306,4.81444291435233)));
		*/
		}
		
		if(data==2) {

		futures.add(cities.document(String.valueOf(15)).set(new Delivery(true,15,15,15, "-12.174714,-76.935345"  ,"nombre" ,true,true,6,15.025448039176997,3.417046489064969,1.7382372232641454)));
		futures.add(cities.document(String.valueOf(16)).set(new Delivery(true,16,16,16, "-12.174169,-76.934637"  ,"nombre" ,true,true,5,4.548369145671527,3.8292635227768974,3.8629909535438585)));
		futures.add(cities.document(String.valueOf(17)).set(new Delivery(true,17,17,17, "-12.173246,-76.935066"  ,"nombre" ,true,true,9,1.4587712614135608,2.3734472527121055,4.481510648602363)));
		futures.add(cities.document(String.valueOf(18)).set(new Delivery(true,18,18,18, "-12.173162,-76.934283"  ,"nombre" ,true,true,4,1.8553124413082547,5.755531088462183,1.580438172174245)));
		futures.add(cities.document(String.valueOf(19)).set(new Delivery(true,19,19,19, "-12.172533,-76.934165"  ,"nombre" ,true,true,9,2.5138658446411615,2.5381643851013953,3.9786643391926537)));
		futures.add(cities.document(String.valueOf(20)).set(new Delivery(true,20,20,20, "-12.173214,-76.933360"  ,"nombre" ,true,true,10,9.480531215805353,2.5366271005534187,4.879419586578397)));
		futures.add(cities.document(String.valueOf(21)).set(new Delivery(true,21,21,21, "-12.173026,-76.933124"  ,"nombre" ,true,true,10,2.9714617205787235,2.1022015687343063,5.49244626161956)));
		futures.add(cities.document(String.valueOf(22)).set(new Delivery(true,22,22,22, "-12.172155,-76.933790"  ,"nombre" ,true,true,1,5.188849705765046,3.2606815683462833,2.5984745127553435)));
		futures.add(cities.document(String.valueOf(23)).set(new Delivery(true,23,23,23, "-12.173655,-76.933350"  ,"nombre" ,true,true,1,5.919253979430498,1.162958912324585,2.800294222468271)));
		futures.add(cities.document(String.valueOf(24)).set(new Delivery(true,24,24,24, "-12.173928,-76.933071"  ,"nombre" ,true,true,10,9.50603004738828,2.200135343764142,2.7330387011151407)));
		
		}
		
		if(data==3) {

		futures.add(cities.document(String.valueOf(25)).set(new Delivery(true,25,25,25, "-12.173781,-76.933478"  ,"nombre" ,true,true,4,15.981974010893904,4.4373644633197715,3.690861384064545)));
		futures.add(cities.document(String.valueOf(26)).set(new Delivery(true,26,26,26, "-12.173172,-76.933897"  ,"nombre" ,true,true,7,3.811359792258643,2.728637561803099,5.968011678792873)));
		futures.add(cities.document(String.valueOf(27)).set(new Delivery(true,27,27,27, "-12.172659,-76.933146"  ,"nombre" ,true,true,9,11.82239701786724,2.988983374585485,2.709383033768641)));
		futures.add(cities.document(String.valueOf(28)).set(new Delivery(true,28,28,28, "-12.172512,-76.932974"  ,"nombre" ,true,true,4,13.511724136349539,3.621061393463714,5.218929403129902)));
		futures.add(cities.document(String.valueOf(29)).set(new Delivery(true,29,29,29, "-12.171725,-76.932996"  ,"nombre" ,true,true,5,12.97187416009143,2.0198850593549382,1.483913564896632)));
		futures.add(cities.document(String.valueOf(30)).set(new Delivery(true,30,30,30, "-12.172187,-76.931944"  ,"nombre" ,true,true,10,13.230753270843918,5.41241856634376,2.1387744347114666)));
		futures.add(cities.document(String.valueOf(31)).set(new Delivery(true,31,31,31, "-12.167682,-76.920736"  ,"nombre" ,true,true,1,4.798993063540971,3.0280504008061246,3.214467414340466)));
		futures.add(cities.document(String.valueOf(32)).set(new Delivery(true,32,32,32, "-12.167652,-76.92060"  ,"nombre" ,true,true,7,4.696638001444081,5.741453350210301,2.7974549629065777)));
		futures.add(cities.document(String.valueOf(33)).set(new Delivery(true,33,33,33, "-12.167677,-76.920544"  ,"nombre" ,true,true,6,14.17494925310409,4.881098568058169,4.157093548259491)));
		futures.add(cities.document(String.valueOf(34)).set(new Delivery(true,34,34,34, "-12.167364,-76.920472"  ,"nombre" ,true,true,7,6.762209520937585,3.8546992566931757,5.990982843389665)));
		}
		
		if(data==4) {

		
		futures.add(cities.document(String.valueOf(35)).set(new Delivery(true,35,35,35, "-12.167495,-76.919902"  ,"nombre" ,true,true,6,2.144231909091213,4.607117628364762,1.1849154155225703)));
		futures.add(cities.document(String.valueOf(36)).set(new Delivery(true,36,36,36, "-12.167773,-76.920166"  ,"nombre" ,true,true,5,15.740876816972914,5.6967770270027085,3.8873829119124705)));
		futures.add(cities.document(String.valueOf(37)).set(new Delivery(true,37,37,37, "-12.167536,-76.919835"  ,"nombre" ,true,true,2,8.659209299079368,4.953376681903915,5.7581674131367215)));
		futures.add(cities.document(String.valueOf(38)).set(new Delivery(true,38,38,38, "-12.167885,-76.919871"  ,"nombre" ,true,true,9,12.99201234715163,2.2627176411014784,5.966364590622437)));
		futures.add(cities.document(String.valueOf(39)).set(new Delivery(true,39,39,39, "-12.167611,-76.919701"  ,"nombre" ,true,true,1,13.1872169503556,2.0137038207006692,5.885259001030441)));
		futures.add(cities.document(String.valueOf(40)).set(new Delivery(true,40,40,40, "-12.167920,-76.919778"  ,"nombre" ,true,true,3,10.439385386602204,5.138090077072932,3.4597868963560727)));
		futures.add(cities.document(String.valueOf(41)).set(new Delivery(true,41,41,41, "-12.167900,-76.919245"  ,"nombre" ,true,true,10,13.748731120499261,2.475309314462634,3.9068987397734363)));
		futures.add(cities.document(String.valueOf(42)).set(new Delivery(true,42,42,42, "-12.168148,-76.919359"  ,"nombre" ,true,true,3,8.456230439139727,4.402715058172199,2.7499479789622754)));
		futures.add(cities.document(String.valueOf(43)).set(new Delivery(true,43,43,43, "-12.168067,-76.919059"  ,"nombre" ,true,true,4,5.695232978299097,1.2858360524378951,4.185307339691287)));
		futures.add(cities.document(String.valueOf(44)).set(new Delivery(true,44,44,44, "-12.168471,-76.918640"  ,"nombre" ,true,true,7,14.300550005417971,5.32374731026962,2.432730857877612)));
		}
		
		if(data==5) {

		futures.add(cities.document(String.valueOf(45)).set(new Delivery(true,45,45,45, "-12.168851,-76.918630"  ,"nombre" ,true,true,7,10.285346834856023,1.7914180969383966,1.0305534478199525)));
		futures.add(cities.document(String.valueOf(46)).set(new Delivery(true,46,46,46, "-12.168709,-76.918412"  ,"nombre" ,true,true,6,3.034241446110854,1.5139064868381282,5.002636373249848)));
		futures.add(cities.document(String.valueOf(47)).set(new Delivery(true,47,47,47, "-12.169169,-76.918081"  ,"nombre" ,true,true,9,6.867855043099765,1.646528893350589,3.4460416709405806)));
		futures.add(cities.document(String.valueOf(48)).set(new Delivery(true,48,48,48, "-12.170150,-76.917610"  ,"nombre" ,true,true,8,6.609644216044738,3.4806375333085917,5.36673423752076)));
		futures.add(cities.document(String.valueOf(49)).set(new Delivery(true,49,49,49, "-12.170616,-76.917703"  ,"nombre" ,true,true,10,1.2301761465727925,4.046400402058383,4.525184735747306)));
		futures.add(cities.document(String.valueOf(50)).set(new Delivery(true,50,50,50, "-12.170929,-76.917553"  ,"nombre" ,true,true,10,10.557100224803623,2.7419835909235752,4.644564135087084)));
		futures.add(cities.document(String.valueOf(51)).set(new Delivery(true,51,51,51, "-12.170899,-76.917238"  ,"nombre" ,true,true,7,1.4209036430504243,5.082794063800858,4.5812913332981395)));
		}
		
		if(data==6) {

		futures.add(cities.document(String.valueOf(52)).set(new Delivery(true,52,52,52, "-12.171410,-76.917264"  ,"nombre" ,true,true,8,1.4571199116913727,2.9349507590504023,3.9610177932035637)));
		futures.add(cities.document(String.valueOf(53)).set(new Delivery(true,53,53,53, "-12.172599,-76.916679"  ,"nombre" ,true,true,10,6.105001219823378,4.273905348177485,3.342700021432621)));
		futures.add(cities.document(String.valueOf(54)).set(new Delivery(true,54,54,54, "-12.171051,-76.917760"  ,"nombre" ,true,true,7,2.130750255092977,5.592147331796265,4.189233263941757)));
		futures.add(cities.document(String.valueOf(55)).set(new Delivery(true,55,55,55, "-12.169938,-76.917051"  ,"nombre" ,true,true,9,9.260240762099443,1.5691821635239869,2.795191216594081)));
		futures.add(cities.document(String.valueOf(56)).set(new Delivery(true,56,56,56, "-12.169230,-76.917083"  ,"nombre" ,true,true,9,10.231738533464766,4.512477908220424,3.850532154104086)));
		futures.add(cities.document(String.valueOf(57)).set(new Delivery(true,57,57,57, "-12.169134,-76.918816"  ,"nombre" ,true,true,2,13.773486702701476,5.379840181723184,3.503708505556939)));
		futures.add(cities.document(String.valueOf(58)).set(new Delivery(true,58,58,58, "-12.168926,-76.917584"  ,"nombre" ,true,true,2,14.674080123127288,3.9016736136288483,3.6284320487351502)));
		futures.add(cities.document(String.valueOf(59)).set(new Delivery(true,59,59,59, "-12.168947,-76.919282"  ,"nombre" ,true,true,6,5.245412008690007,2.4358544248513643,3.4954197811278767)));
		}
		
		ApiFutures.allAsList(futures).get();

	}
	
	

}
