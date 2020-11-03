package com.backend.tienda.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CalculateTime {


	public static String calculateTimeInRange(String horario,String tiempo_espera,String fecha_entrega) {

		String tiempototal="";

		Timestamp time=new Timestamp(System.currentTimeMillis());

		String fecha1=
				LocalDate                       // Represents an entire day, without time-of-day and without time zone.
				.now(                           // Capture the current date.
						ZoneId.of( "America/Lima" )  // Returns a `ZoneId` object.
						).toString();

		Timestamp fecha_entre=Timestamp.valueOf(fecha_entrega);


		String fecha0=
				LocalDate                       // Represents an entire day, without time-of-day and without time zone.
				.now(                           // Capture the current date.
						ZoneId.of( "America/Lima" )  // Returns a `ZoneId` object.
						).minusDays(1).toString();

		Timestamp yesterday=Timestamp.valueOf(fecha0+" 00:00:00.000");


		String fecha2=
				LocalDate                       // Represents an entire day, without time-of-day and without time zone.
				.now(                           // Capture the current date.
						ZoneId.of( "America/Lima" )   // Returns a `ZoneId` object.
						).plusDays(1).toString();

		Timestamp tomorrow=Timestamp.valueOf(fecha2+" 00:00:00.000");


		System.out.println("Ayer "+yesterday+" | tomorrow "+tomorrow +" | hoy :"+time);


		String[] tiempo=horario.split("- ");


		Timestamp horarioInicio=Timestamp.valueOf(convertTimestamp(tiempo[0],fecha1));

		Timestamp horarioFin=Timestamp.valueOf(convertTimestamp(tiempo[1],fecha1));

		int tiempoToLong=Integer.valueOf(tiempo_espera)*60000;
		Long l= new Long(tiempoToLong);

		System.out.println(time.after(yesterday) +" "+time.before(tomorrow));


		if(fecha_entre.after(yesterday) && fecha_entre.before(tomorrow)) {

			System.out.println("Estamos en que el dia es hoy");



			if(time.after(horarioInicio) && time.before(horarioFin)) {
				System.out.println("Horario en el intervalo");


				tiempototal=String.valueOf(tiempoToLong);

			}else {
				System.out.println("Horario despues del intervalo");

				long diference=horarioInicio.getTime()-time.getTime(); 


				if(diference<0) {

					tiempototal=String.valueOf(tiempoToLong);

				}else {
					System.out.println(horarioInicio+" "+time);


					long total=l+diference;

					tiempototal=String.valueOf(total);
				}


			}


		}else {

			System.out.println("Dia de mañana ");


			String[] fecha3=fecha_entrega.split(" ");

			Timestamp ts = Timestamp.valueOf(convertTimestamp(tiempo[0],fecha3[0]));


			long diference=ts.getTime()-time.getTime(); 

			System.out.println(ts+" "+time);


			//Long l= new Long(tiempoToLong);

			long total=l+diference;

			tiempototal=String.valueOf(total);

		}

		return tiempototal;
	}



	public  static String convertTimestamp(String tiempo,String fecha) {


		String[] data=tiempo.split(" ");


		String input = fecha+" "+data[0]+":00 "+data[1].toLowerCase();
		//Format of the date defined in the input String
		return  transformDate(input);

	}

	public  static Timestamp convertTimestampToDate(String tiempo,String fecha,String tiempo_espera) {

	
		System.out.println("tiempo : "+ tiempo+" , fecha : "+fecha+" , tiempo_espera :"+tiempo_espera);
		
		Timestamp time;

		String[] data=tiempo.split(" ");
		String[] data2=data[0].split(":");
				
		
		String[] data3=fecha.split(" ");

		String input = data3[0]+" "+data2[0]+":"+tiempo_espera+":00 "+data[1].toLowerCase();		
		
	
		time=new Timestamp(System.currentTimeMillis());

		String fecha0=
				LocalDate                       // Represents an entire day, without time-of-day and without time zone.
				.now(                           // Capture the current date.
						ZoneId.of( "America/Lima" )  // Returns a `ZoneId` object.
						).toString();

		Timestamp yesterday=Timestamp.valueOf(transformDate(fecha0+" "+data2[0]+":00:00 "+data[1].toLowerCase()));	


		
		String fecha2=
				LocalDate                       // Represents an entire day, without time-of-day and without time zone.
				.now(                           // Capture the current date.
						ZoneId.of( "America/Lima" )   // Returns a `ZoneId` object.
						).toString();

		
		
		
		Timestamp tomorrow=Timestamp.valueOf(transformDate(fecha2+" "+(Integer.valueOf(data2[0])+1)+":00:00 "+data[4].toLowerCase()));

		System.out.println("yesterday"+yesterday+" tiempo : "+time+" tomorrow"+tomorrow);

		
		if(time.after(yesterday) && time.before(tomorrow)) {
		
/*		long yes=yesterday.getTime();
		long tom=tomorrow.getTime();
		long ti=time.getTime();

		System.out.println("yesterday"+yes+" tiempo : "+ti+" tomorrow"+tom);

		if(ti>yes && ti<tom) {*/


			int wait_time=Integer.valueOf(tiempo_espera)*60000;
			
			long total=time.getTime()+new Long(wait_time);
			
			
			time=new Timestamp(total);
			
			System.out.println("result 1: "+time);

			
		}else {

			time=Timestamp.valueOf(CalculateTime.transformDate(input));
			
			System.out.println("result2 : "+time);

		}
		
		
		System.out.println("result : "+time);



		return time;

	}

	public static String transformDate(String fecha) {

	

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
		//Desired format: 24 hour format: Change the pattern as per the need
		DateFormat outputformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		String output = null;
		try{
			//Converting the input String to Date
			date= df.parse(fecha);
			//Changing the format of date and storing it in String
			output = outputformat.format(date);
			//Displaying the date
		}catch(ParseException pe){
			pe.printStackTrace();
		}


		return output;
	}


}
