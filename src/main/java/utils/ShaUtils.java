package utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Sha工具类
 * @author humenglin
 */
public class ShaUtils {

    /**
     * 计算字符串的sha256值
     * @param message
     * @return
     */
    public static String getHashValueBySha256(String message) {
        if (StringUtils.isEmpty(message)) {
            return null;
        }
        return DigestUtils.sha256Hex(message);
    }
}
