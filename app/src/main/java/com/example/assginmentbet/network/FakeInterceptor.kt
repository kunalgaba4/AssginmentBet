package com.example.assginmentbet.network

import okhttp3.*
import java.io.IOException
import java.net.URLDecoder

/**
 *
 */
class FakeInterceptor : Interceptor {
    private var mContentType = "application/json"

    /**
     * Set content type for header
     * @param contentType Content type
     * @return FakeInterceptor
     */
    fun setContentType(contentType: String): FakeInterceptor {
        mContentType = contentType
        return this
    }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var response: Response? = null
        try {
            val responseStringBuilder = StringBuilder()
            val username = (chain.request().body() as FormBody).encodedValue(0)
            val afterDecode: String = URLDecoder.decode(username, "UTF-8")

            if (username.equals("Error")){
                responseStringBuilder.append("{\"username\": \"$afterDecode\",\"isSuccessful\": false}")
                response = Response.Builder()
                    .code(404)
                    .body( ResponseBody.create(
                        MediaType.parse(mContentType),
                        responseStringBuilder.toString().toByteArray()
                    ))
                    .protocol(Protocol.HTTP_1_0)
                    .message("Unable to Login")
                    .addHeader("content-type", mContentType)
                    .request(chain.request())
                    .build()

            }else{
                responseStringBuilder.append("{\"username\": \"$afterDecode\",\"isSuccessful\": true}")
                response = Response.Builder()
                    .code(200)
                    .message(responseStringBuilder.toString())
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(
                        ResponseBody.create(
                            MediaType.parse(mContentType),
                            responseStringBuilder.toString().toByteArray()
                        )
                    )
                    .addHeader("content-type", mContentType)
                    .build()
            }

        } catch (e: Exception) {
            println(e.message)
        }
        return response!!
    }
}