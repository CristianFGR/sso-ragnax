package com.ragnax.ssorepositorio.servicio.utilidades;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.ragnax.domain.zapala.modelo.*;


@Service
public class ChapalaImpl{

//	public Zapala generarTiempoDuracion(ConvertirStrFechaConFormatToTimestamp convertirStrFechaConFormatToTimestamp) throws Exception{
//		try{
//			throw new Exception("cooperaste");
//
//		}catch(Exception e){
//			throw new Exception(e);
//		}
//	}

		public static Zapala generarTiempoDuracion(ZapalaRequest zapalaRequest)  throws Exception {
			try{
				return new Zapala(zapalaRequest.getLocalDateTime().getSecond()+
				""+zapalaRequest.getLocalDateTime().getNano());
			}catch(Exception e){
				throw new Exception(e);
			}

		}

	public  static Timestamp convertirStrFechaConFormatToTimestamp(ZapalaRequest zapalaRequest) throws Exception{
		//    	SimpleDateFormat formatInicial = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'"); 2019-10-22T10:30:00
		try{
//			throw new Exception("Cooperaste");
			if(isValidDate(zapalaRequest)){
				
				Date fechaFinal = new SimpleDateFormat(zapalaRequest.getListaString().get(1))
						.parse(zapalaRequest.getListaString().get(0));
				
				return new Timestamp(fechaFinal.getTime());
			}else{
				throw new Exception("Jue");
			}
		}catch(Exception e){
			throw new Exception(e);
		}

	}

	public  static boolean isValidDate(ZapalaRequest zapalaRequest) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat(zapalaRequest.getListaString().get(1));
		try{
			sdf.setLenient(false);
			sdf.parse(zapalaRequest.getListaString().get(0));
			return true;
		}
		catch(ParseException e){
			throw new Exception(e);
		}
	}

	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public  static boolean validarPatronEmail(ZapalaRequest zapalaRequest) throws Exception{
		try {
			Pattern pattern = Pattern.compile(PATTERN_EMAIL);

			//			textoEmail = eliminarEspacioInicioFinal(textoEmail);

			Matcher matcher = pattern.matcher(zapalaRequest.getListaString().get(0));

			return matcher.matches();
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public  static Zapala generarPatronRUT(ZapalaRequest zapalaRequest) throws Exception{
		try {
			String textoRUT = limpiarPatronRUT(zapalaRequest.getListaString().get(0));

			int cont = 0;

			String rutFormateado = "-" + textoRUT.substring(textoRUT.length() - 1);

			for (int i = textoRUT.length() - 2; i >= 0; i--) {
				rutFormateado = textoRUT.substring(i, i + 1) + rutFormateado;
				cont++;
				if (cont == 3 && i != 0) {
					rutFormateado = "." + rutFormateado;
					cont = 0;
				}
			}
			return new Zapala(rutFormateado);
//			return rutFormateado;

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	private static String limpiarPatronRUT(String textoRUT) throws Exception{
		textoRUT = textoRUT.replace(".", "");
		textoRUT = textoRUT.replace("-", "");

		return textoRUT;

	}
	
	public  static Zapala generarCodigoByNumero(ZapalaRequest zapalaRequest) throws Exception{

		try {
			Map<String, String> mapaCambio = new HashMap<String, String>();

			String[] respuesta = new String[zapalaRequest.getListaString().get(0).length()];

			String[] arraySplit = zapalaRequest.getListaString().get(0).split("");

			mapaCambio.put("1","U");
			mapaCambio.put("2","D");
			mapaCambio.put("3","T");
			mapaCambio.put("4","F");
			mapaCambio.put("5","C");
			mapaCambio.put("6","S");
			mapaCambio.put("7","E");
			mapaCambio.put("8","O");
			mapaCambio.put("9","N");
			mapaCambio.put("0","Z");

			for(int i=0; i < arraySplit.length; i++) {
				respuesta[i] = mapaCambio.get(arraySplit[i]);
			}
			
			return new Zapala(String.join("", respuesta));
			
		}
		catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public static Zapala generarCodigoByNumeroByEncodear (ZapalaRequest zapalaRequest) throws Exception{
		System.out.println("encriptar"+zapalaRequest.getListaString().get(0));
		
		java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();

		try {
			Map<String, String> mapaCambio = new HashMap<String, String>();

			String[] respuesta = new String[zapalaRequest.getListaString().get(0).length()];

			String[] arraySplit = zapalaRequest.getListaString().get(0).split("");

			mapaCambio.put("1","U");
			mapaCambio.put("2","D");
			mapaCambio.put("3","T");
			mapaCambio.put("4","F");
			mapaCambio.put("5","C");
			mapaCambio.put("6","S");
			mapaCambio.put("7","E");
			mapaCambio.put("8","O");
			mapaCambio.put("9","N");
			mapaCambio.put("0","Z");

			for(int i=0; i < arraySplit.length; i++) {
				respuesta[i] = mapaCambio.get(arraySplit[i]);
			}

			return new Zapala(String.join("", respuesta)+"-"+ encoder.encodeToString(zapalaRequest.getListaString().get(1).getBytes(StandardCharsets.UTF_8) ));

		}
		catch (Exception ex) {
			throw new Exception(ex);
		}
	}
	
	public  static Zapala generarMD5(ZapalaRequest zapalaRequest) throws Exception {
		try {
			System.out.println("MD5:"+zapalaRequest.getListaString().get(0));
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(zapalaRequest.getListaString().get(0).getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			
			return new Zapala(hashtext);
			
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
	
	public  static <T> Zapala generacionSHA(T content, Class<T> typeRequest)
	{
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(((String) content).getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		//convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i=0;i<byteData.length;i++) {
			String hex=Integer.toHexString(0xff & byteData[i]);
			if(hex.length()==1) hexString.append('0');
			hexString.append(hex);
		}
		
		return new Zapala(hexString.toString());
	}
	
	public  static <T> Zapala generacionSHA(ZapalaRequest zapalaRequest) throws Exception {
	
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(((String) zapalaRequest.getListaString().get(0)).getBytes());

		byte byteData[] = md.digest();

		//convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		//convert the byte to hex format method 2
		StringBuffer hexString = new StringBuffer();
		for (int i=0;i<byteData.length;i++) {
			String hex=Integer.toHexString(0xff & byteData[i]);
			if(hex.length()==1) hexString.append('0');
			hexString.append(hex);
		}
		
		return new Zapala(hexString.toString());
		
	}

} 
