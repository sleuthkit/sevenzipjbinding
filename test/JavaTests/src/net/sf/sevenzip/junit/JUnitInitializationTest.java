package net.sf.sevenzip.junit;

import static org.junit.Assert.assertTrue;
import net.sf.sevenzip.SevenZip;
import net.sf.sevenzip.SevenZipNativeInitializationException;

import org.junit.Test;

/**
 * Tests initialization of SevenZipJBinding
 * 
 * @author Boris Brodski
 * 
 */
public class JUnitInitializationTest extends JUnitTestBase {

	/**
	 * Tests standard initialization of SevenZipJBinding by the base class for all JUnit tests.
	 */
	@Test
	public void initializationTest() {
		assertTrue("SevenZip wasn't initialized by base class " + this.getClass().getSuperclass().getCanonicalName(),
				SevenZip.isInitialized());
	}

	/**
	 * After SevenZipJBinding was initialized by the base class {@link JUnitTestBase} another call to any of
	 * initialization routines should return no exception.
	 * 
	 * @throws SevenZipNativeInitializationException
	 *             throws, if SevenZipJBinding will proceed with the initialization and it's will fail.
	 */
	@Test
	public void doubleInitializationTest() throws SevenZipNativeInitializationException {
		SevenZip.initLibraryFromFile("FileThatDoesNotExists.txt");
		SevenZip.initSevenZipFromPlatformJAR();
		SevenZip.initSevenZipFromPlatformJAR("DirectoryThatDoesNotExists");
	}

}
