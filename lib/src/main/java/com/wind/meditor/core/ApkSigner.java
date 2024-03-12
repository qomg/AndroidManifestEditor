package com.wind.meditor.core;

import com.wind.meditor.utils.Log;
import com.wind.meditor.utils.ShellCmdUtil;

import java.io.File;

/**
 * @author Windysha
 */
public class ApkSigner {

    public static void signApk(String apkPath, String keyStorePath, String signedApkPath) {
        try {
            long time = System.currentTimeMillis();
            File keystoreFile = new File(keyStorePath);
            if (keystoreFile.exists()) {
                String[] signCmd = new String[]{
                        "jarsigner",
                        "-keystore",
                        keyStorePath,
                        "-storepass",
                        "manifest_editor",
                        "-signedjar",
                        signedApkPath,
                        apkPath,
                        "-digestalg",
                        "SHA1",
                        "-sigalg",
                        "SHA1withRSA",
                        "key0"
                };
                String result = ShellCmdUtil.execCmd(signCmd, null);
                Log.i(" sign apk time is : " + ((System.currentTimeMillis() - time)) +
                        "ms\n\n" + "  result=" + result);
            }
        } catch (Throwable e) {
            Log.i("sign apk failed, result ==> " + e.getMessage());
            e.printStackTrace();
        }
    }
}
