package xfiles.util;

import java.util.Scanner;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class SaltedPasswordEncrypter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("tell me user name (salt)?");
		// we're gonna use username as salt...
		String salt = scanner.nextLine();
		System.out.println("tell me the password?");
		String password = scanner.nextLine();
		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		String encryptedPassword = encoder.encodePassword(password, salt);
		System.out.println(encryptedPassword);
	}
}
