package nicolis_A_Provabella.bin;

import java.io.File;
import java.util.ArrayList;

class Provabella {

	public Provabella() {

	}
}

class ProvabellaTest {
	public static void main(String[] args) {

		System.out.println("Start");

		//		CALCOLO PATH RELATIVO UNIVERSALE
		//----------------------------------------------------------------------
		String tempPath = new File(
				String.valueOf(Provabella.class.getPackage()).replace("package ", "").replace(".", "/")
		).getParent();
		File uesrPath = new File(System.getProperty("user.dir"));
		String projectPath = uesrPath.getName().equals(tempPath) ?
				uesrPath.getPath() :
				new File(uesrPath.getPath() + "/src").exists() ?
						uesrPath.getPath() + "/src/" + tempPath :
						uesrPath.getPath() + tempPath;
		//----------------------------------------------------------------------

		// COSTANTI
		String resursesPath = "/file/";

		System.out.println("Hello, World");

		ArrayList





		System.out.println("End");

	}
}