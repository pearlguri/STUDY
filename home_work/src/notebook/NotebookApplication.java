package notebook;

public class NotebookApplication {
	public static void main(String[] args) {
		PortableNotebook elec = new PortableNotebook("한글2020", "크롬", "영화", "안드로이드");
		//프로그램 모드를 문자로 출력 어떻게 하지..?
		elec.writeDocumentation();
		elec.watchVideo();
		elec.changeMode(2);
		elec.useApp(2);
		elec.searchInternet();

		
	}
}
