package com.kh.semiProject.common;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptFormatter {

	public static void main(String[] args) {
		String[] plainText = { "1234", "480218", "500530", "511016", "520602", "530714", "530718", "540101", "540103",
				"540304", "570315", "580105", "580721", "620225", "620303", "630329", "640219", "651030", "670127",
				"670510", "670609", "680228", "680502", "680717", "700808", "720822", "720910", "741016", "760326",
				"760421", "780702", "800304", "450215", "480613", "481002", "481022", "481120", "510117", "530617",
				"540110", "550802", "551011", "561222", "570904", "600704", "600720", "610121", "610420", "640125",
				"650604", "650712", "680212", "681210", "700619", "710130", "710205", "721020", "730123", "830101",
				"490114", "490222", "491130", "500830", "521201", "570825", "580305", "590221", "590401", "600801",
				"640128", "650620", "650722", "650816", "670326", "671224", "680309", "700510", "710405", "800707",
				"490205", "540810", "561130", "601004", "641208", "670208", "760210", "780501", "511009", "521112",
				"540202", "541201", "551030", "561101", "561225", "571005", "580405", "600326", "610130", "620601",
				"621011", "641124", "650330", "650828", "681201", "700816", "720602", "740924", "760219", "admin1234" };

		for (int i = 0; i < plainText.length; i++) {

			System.out.println(getSHA512(plainText[i]));

		}

	}

	// 암호화를 위한 SHA512 메소드 작성
	private static String getSHA512(String pwd) {

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = pwd.getBytes(Charset.forName("UTF-8"));
			md.update(bytes);

			return Base64.getEncoder().encodeToString(md.digest());

		} catch (NoSuchAlgorithmException e) {

			System.out.println("암호화 에러 발생!");
			e.printStackTrace();

			return null;
		}
	}
}
