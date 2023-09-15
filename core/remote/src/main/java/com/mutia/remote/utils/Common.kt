package com.mutia.remote.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.core.content.ContextCompat
import com.alibaba.sdk.android.oss.OSSClient
import com.alibaba.sdk.android.oss.common.auth.HmacSHA1Signature
import com.mutia.base.utils.orFalse


fun generateAlibabaCredential(accessKey: String, secretKey: String?, content: String?): String {
    var signature: String
    try {
        signature = HmacSHA1Signature().computeSignature(secretKey, content)
        signature = signature.trim { it <= ' ' }
    } catch (e: Exception) {
        throw IllegalStateException("Compute signature failed!", e)
    }
    return "OSS $accessKey:$signature"
}

//fun generateOssURL(ossClient: OSSClient, value: String): String {
//    var bucket = value
//    if (bucket.contains(ConstKeys.DO_BUCKET)) {
//        bucket = bucket.replace(ConstKeys.DO_BUCKET, "")
//    }
//    val req = GeneratePresignedUrlRequest(ConstKeys.DO_BUCKET, bucket)
//    req.expiration = (15 * 60).toLong()

//    return try {
//        ossClient.presignConstrainedObjectURL(req)
//    } catch (e: Exception) {
//        ""
//    }
//}


@Suppress("DEPRECATION")
inline val Context.isNetworkAvailable: Boolean
    get() {
        val manager = ContextCompat.getSystemService(this, ConnectivityManager::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val capabilities = manager?.getNetworkCapabilities(manager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
                }
            }
        } else {
            return manager?.activeNetworkInfo?.isConnected.orFalse()
        }
        return false
    }