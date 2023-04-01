import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import org.junit.Test;

import java.net.MalformedURLException;

public class TT {
    @Test
    public void test(){
        String url = "smb://43.143.200.52/C:\\Users\\Administrator\\Desktop\\zeamap/";
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", "Administrator", "LIkeqin20221008");
        SmbFile smbFile = null;
        try {
            smbFile = new SmbFile(url, auth);
            SmbFile[] files = smbFile.listFiles();
            for (SmbFile file : files) {
                System.out.println(file.getName());
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (SmbException e) {
            e.printStackTrace();
        }
    }
}
