import static org.junit.Assert.*;

import java.util.Random;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPMessage;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ServerTests {

	private static String url = "http://practicum-mckeown.rhcloud.com/AndroidServer/services/";
	private static Soap soap = new Soap(url);
	private static User a = new User(0, 23, "aemail", "aphoneNbr",
			"afirstName", "alastName");
	private static User b = new User(0, 23, "bemail", "bphoneNbr",
			"bfirstName", "blastName");
	private static User c = new User(0, 23, "cemail", "cphoneNbr",
			"cfirstName", "clastName");
	private static User d = new User(0, 23, "demail", "dphoneNbr",
			"dfirstName", "dlastName");
	private static User e = new User(0, 23, "eemail", "ephoneNbr",
			"efirstName", "elastName");
	private int aLogin = 0;
	private int bLogin = 0;
	private int cLogin = 0;
	private int dLogin = 0;
	private int eLogin = 0;
	private User aa = a;
	private User bb = b;
	private User cc = c;
	private User dd = d;
	private User ee = e;
	private boolean aEdit = false;
	private boolean bEdit = false;
	private boolean cEdit = false;
	private boolean dEdit = false;
	private boolean eEdit = false;
	private boolean aDeleted = false;
	private boolean bDeleted = false;
	private boolean cDeleted = false;
	private boolean dDeleted = false;
	private boolean eDeleted = false;

	@Test
	public void auserIDAEstablised() {
		try {
			a.setUserID(soap.createCreateUserRequest(a.getAge(), a.getEmail(),
					a.getFristName(), a.getLastName(), "a", "a",
					a.getPhoneNbr()));
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID a !=0", false, a.getUserID() == 0);
	}

	@Test
	public void buserIDBEstablised() {

		try {
			b.setUserID(soap.createCreateUserRequest(b.getAge(), b.getEmail(),
					b.getFristName(), b.getLastName(), "b", "b",
					b.getPhoneNbr()));
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID b !=0", false, b.getUserID() == 0);
	}

	@Test
	public void cuserIDCEstablised() {

		try {
			c.setUserID(soap.createCreateUserRequest(c.getAge(), c.getEmail(),
					c.getFristName(), c.getLastName(), "c", "c",
					c.getPhoneNbr()));
			System.out.println(c.getUserID() + "establlish");
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID c !=0", false, c.getUserID() == 0);
	}

	@Test
	public void duserIDDEstablised() {

		try {
			d.setUserID(soap.createCreateUserRequest(d.getAge(), d.getEmail(),
					d.getFristName(), d.getLastName(), "d", "d",
					d.getPhoneNbr()));
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID d !=0", false, d.getUserID() == 0);
	}

	@Test
	public void euserIDEEstablised() {
		try {
			e.setUserID(soap.createCreateUserRequest(e.getAge(), e.getEmail(),
					e.getFristName(), e.getLastName(), "e", "e",
					e.getPhoneNbr()));
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID e !=0", false, e.getUserID() == 0);
	}

	@Test
	public void floginResponseA() {

		try {
			aLogin = soap.createLoginRequest("a", "a");

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID a == login a", true, a.getUserID() == aLogin);
	}

	@Test
	public void gloginResponseB() {

		try {

			bLogin = soap.createLoginRequest("b", "b");

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID b == login b", true, b.getUserID() == bLogin);

	}

	@Test
	public void hloginResponseC() {

		try {

			cLogin = soap.createLoginRequest("c", "c");

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID c == login c", true, c.getUserID() == cLogin);

	}

	@Test
	public void iloginResponseD() {

		try {

			dLogin = soap.createLoginRequest("d", "d");

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID d == login d", true, d.getUserID() == dLogin);

	}

	@Test
	public void jloginResponseE() {

		try {

			eLogin = soap.createLoginRequest("e", "e");
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("userID e == login e", true, e.getUserID() == eLogin);
	}

	@Test
	public void kAequalsDB() {
		try {
			aa = soap.createGetUserDataRequest(a.getUserID());

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("user a age == db age", true, a.getAge() == aa.getAge());

		assertEquals("user a email == db email", true,
				a.getEmail().equals(aa.getEmail()));

		assertEquals("user a phoneNbr == db phoneNbr", true, a.getEmail()
				.equals(aa.getEmail()));

		assertEquals("user a first name == db firstname", true, a
				.getFristName().equals(aa.getFristName()));
		assertEquals("user a last name == db lastname", true, a.getLastName()
				.equals(aa.getLastName()));

	}

	@Test
	public void lBequalsDB() {
		try {

			bb = soap.createGetUserDataRequest(b.getUserID());

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("user b age == db age", true, b.getAge() == bb.getAge());

		assertEquals("user b email == db email", true,
				b.getEmail().equals(bb.getEmail()));

		assertEquals("user b phoneNbr == db phoneNbr", true, b.getEmail()
				.equals(bb.getEmail()));
		assertEquals("user b first name == db firstname", true, b
				.getFristName().equals(bb.getFristName()));
		assertEquals("user b last name == db lastname", true, b.getLastName()
				.equals(bb.getLastName()));

	}

	@Test
	public void mCequalsDB() {
		try {

			cc = soap.createGetUserDataRequest(c.getUserID());
			System.out.println(c.getUserID() + "equalsdb");
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("user c age == db age", true, c.getAge() == cc.getAge());

		assertEquals("user c email == db email", true,
				c.getEmail().equals(cc.getEmail()));

		assertEquals("user c phoneNbr == db phoneNbr", true, c.getEmail()
				.equals(cc.getEmail()));

		assertEquals("user c first name == db firstname", true, c
				.getFristName().equals(cc.getFristName()));

		assertEquals("user c last name == db lastname", true, c.getLastName()
				.equals(cc.getLastName()));

	}

	@Test
	public void nDequalsDB() {
		try {

			dd = soap.createGetUserDataRequest(d.getUserID());

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("user d age == db age", true, d.getAge() == dd.getAge());

		assertEquals("user d email == db email", true,
				d.getEmail().equals(dd.getEmail()));

		assertEquals("user d phoneNbr == db phoneNbr", true, d.getEmail()
				.equals(dd.getEmail()));

		assertEquals("user d first name == db firstname", true, d
				.getFristName().equals(dd.getFristName()));

		assertEquals("user d last name == db lastname", true, d.getLastName()
				.equals(dd.getLastName()));

	}

	@Test
	public void oEequalsDB() {
		try {

			ee = soap.createGetUserDataRequest(e.getUserID());
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("user e age == db age", true, e.getAge() == ee.getAge());

		assertEquals("user e email == db email", true,
				e.getEmail().equals(ee.getEmail()));

		assertEquals("user e phoneNbr == db phoneNbr", true, e.getEmail()
				.equals(ee.getEmail()));

		assertEquals("user e first name == db firstname", true, e
				.getFristName().equals(ee.getFristName()));

		assertEquals("user e last name == db lastname", true, e.getLastName()
				.equals(ee.getLastName()));
	}

	@Test
	public void pprocessAEdit() {
		try {
			aEdit = soap.createEditAcctRequest(a.getAge() + 1,
					a.getEmail() + 1, a.getFristName() + 1,
					a.getLastName() + 1, a.getUserID(), a.getPhoneNbr() + 1);

		} catch (Exception z) {
			z.printStackTrace();
		}
		assertEquals("a edited", true, aEdit);

	}

	@Test
	public void qprocessBEdit() {
		try {

			bEdit = soap.createEditAcctRequest(b.getAge() + 1,
					b.getEmail() + 1, b.getFristName() + 1,
					b.getLastName() + 1, b.getUserID(), b.getPhoneNbr() + 1);

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("b edited", true, bEdit);

	}

	@Test
	public void rprocessCEdit() {
		try {

			cEdit = soap.createEditAcctRequest(c.getAge() + 1,
					c.getEmail() + 1, c.getFristName() + 1,
					c.getLastName() + 1, c.getUserID(), c.getPhoneNbr() + 1);

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("c edited", true, cEdit);

	}

	@Test
	public void sprocessDEdit() {
		try {

			dEdit = soap.createEditAcctRequest(d.getAge() + 1,
					d.getEmail() + 1, d.getFristName() + 1,
					d.getLastName() + 1, d.getUserID(), d.getPhoneNbr() + 1);

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("d edited", true, dEdit);

	}

	@Test
	public void tprocessEEdit() {
		try {

			eEdit = soap.createEditAcctRequest(e.getAge() + 1,
					e.getEmail() + 1, e.getFristName() + 1,
					e.getLastName() + 1, e.getUserID(), e.getPhoneNbr() + 1);
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("e edited", true, eEdit);
	}

	@Test
	public void uCheckAWrong() {
		try {
			aa = soap.createGetUserDataRequest(a.getUserID());

		} catch (Exception z) {
			z.printStackTrace();
		}
		assertEquals("user a age == db age", false, a.getAge() == aa.getAge());

		assertEquals("user a email == db email", false,
				a.getEmail().equals(aa.getEmail()));

		assertEquals("user a phoneNbr == db phoneNbr", false, a.getEmail()
				.equals(aa.getEmail()));

		assertEquals("user a first name == db firstname", false, a
				.getFristName().equals(aa.getFristName()));

		assertEquals("user a last name == db lastname", false, a.getLastName()
				.equals(aa.getLastName()));

	}

	@Test
	public void vcheckBWrong() {
		try {

			bb = soap.createGetUserDataRequest(b.getUserID());

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("user b age == db age", false, b.getAge() == bb.getAge());

		assertEquals("user b email == db email", false,
				b.getEmail().equals(bb.getEmail()));

		assertEquals("user b phoneNbr == db phoneNbr", false, b.getEmail()
				.equals(bb.getEmail()));

		assertEquals("user b first name == db firstname", false, b
				.getFristName().equals(bb.getFristName()));

		assertEquals("user b last name == db lastname", false, b.getLastName()
				.equals(bb.getLastName()));

	}

	@Test
	public void wcheckCWrong() {
		try {

			cc = soap.createGetUserDataRequest(c.getUserID());

		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("user c age == db age", false, c.getAge() == cc.getAge());

		assertEquals("user c email == db email", false,
				c.getEmail().equals(cc.getEmail()));

		assertEquals("user c phoneNbr == db phoneNbr", false, c.getEmail()
				.equals(cc.getEmail()));

		assertEquals("user c first name == db firstname", false, c
				.getFristName().equals(cc.getFristName()));

		assertEquals("user c last name == db lastname", false, c.getLastName()
				.equals(cc.getLastName()));

	}

	@Test
	public void xcheckDWrong() {
		try {

			dd = soap.createGetUserDataRequest(d.getUserID());
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("user d age == db age", false, d.getAge() == dd.getAge());

		assertEquals("user d email == db email", false,
				d.getEmail().equals(dd.getEmail()));

		assertEquals("user d phoneNbr == db phoneNbr", false, d.getEmail()
				.equals(dd.getEmail()));

		assertEquals("user d first name == db firstname", false, d
				.getFristName().equals(dd.getFristName()));

		assertEquals("user d last name == db lastname", false, d.getLastName()
				.equals(dd.getLastName()));

	}

	@Test
	public void ycheckEWrong() {
		try {

			ee = soap.createGetUserDataRequest(e.getUserID());
		} catch (Exception z) {
			z.printStackTrace();
		}

		assertEquals("user e age == db age", false, e.getAge() == ee.getAge());

		assertEquals("user e email == db email", false,
				e.getEmail().equals(ee.getEmail()));

		assertEquals("user e phoneNbr == db phoneNbr", false, e.getEmail()
				.equals(ee.getEmail()));

		assertEquals("user e first name == db firstname", false, e
				.getFristName().equals(ee.getFristName()));

		assertEquals("user e last name == db lastname", false, e.getLastName()
				.equals(ee.getLastName()));
	}

//	@Test
//	public void zdeleteA() {
//
//		try {
//			aDeleted = soap.createDeleteUserRequest(a.getUserID());
//
//		} catch (Exception z) {
//			z.printStackTrace();
//		}
//		assertEquals("a deleted", true, aDeleted);
//
//	}
//
//	@Test
//	public void zadeleteB() {
//
//		try {
//
//			bDeleted = soap.createDeleteUserRequest(b.getUserID());
//
//		} catch (Exception z) {
//			z.printStackTrace();
//		}
//
//		assertEquals("b deleted", true, bDeleted);
//
//	}
//
//	@Test
//	public void zbdeleteC() {
//
//		try {
//
//			cDeleted = soap.createDeleteUserRequest(c.getUserID());
//
//		} catch (Exception z) {
//			z.printStackTrace();
//		}
//
//		assertEquals("c deleted", true, cDeleted);
//
//	}
//
//	@Test
//	public void zcdeleteD() {
//
//		try {
//
//			dDeleted = soap.createDeleteUserRequest(d.getUserID());
//
//		} catch (Exception z) {
//			z.printStackTrace();
//		}
//
//		assertEquals("d deleted", true, dDeleted);
//
//	}
//
//	@Test
//	public void zddeleteE() {
//
//		try {
//
//			eDeleted = soap.createDeleteUserRequest(e.getUserID());
//		} catch (Exception z) {
//			z.printStackTrace();
//		}
//
//		assertEquals("e deleted", true, eDeleted);
//	}

	public static String getRandomNumber(int digCount) {
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(digCount);
		for (int i = 0; i < digCount; i++)
			sb.append((char) ('0' + rnd.nextInt(10)));
		return sb.toString();
	}
}
