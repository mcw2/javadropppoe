package javadorpppoe;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConnectNetWork {
	static String Connectname;
	static String ConnectuserAndPass;
	//static String Connectpass;
   public ConnectNetWork (String Connectname,String ConnectuserAndPass){
	   this.Connectname=Connectname;
	   this.ConnectuserAndPass=ConnectuserAndPass;
	  // this.Connectpass=Connectpass;	
}


	public static boolean connAdsl() throws Exception {
		System.out.println("正在建立连接.");
		String adslCmd = "rasdial " + Connectname + " " + ConnectuserAndPass;
		String tempCmd = executeCmd(adslCmd);
		// 判断是否连接成功
		if (tempCmd.indexOf("已连接") > 0) {
			System.out.println("已成功建立连接.");
			return true;
		} else {
			System.err.println(tempCmd);
			System.err.println("建立连接失败");
			return false;
		}
	}

	public static boolean cutAdsl(String adslTitle) throws Exception {
		String cutAdsl = "rasdial " + adslTitle + " /disconnect";
		String result = executeCmd(cutAdsl);

		if (result.indexOf("没有连接") != -1) {
			System.err.println(adslTitle + "连接不存在!");
			return false;
		} else {
			System.out.println("连接已断开");
			return true;
		}
	}
 
	public static String executeCmd(String strCmd) throws Exception {
		Process p = Runtime.getRuntime().exec("cmd /c " + strCmd);
		StringBuilder sbCmd = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(), "GB2312"));

		String line;
		while ((line = br.readLine()) != null) {
			sbCmd.append(line + "\n");
		}
		return sbCmd.toString();

	}


	public String getConnectname() {
		return Connectname;
	}


	public void setConnectname(String connectname) {
		Connectname = connectname;
	}


	public String getConnectuser() {
		return ConnectuserAndPass;
	}


	public void setConnectuser(String ConnectuserAndPass) {
		ConnectuserAndPass = ConnectuserAndPass;
	}


	

}