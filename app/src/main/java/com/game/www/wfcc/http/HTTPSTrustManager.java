package com.game.www.wfcc.http;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HTTPSTrustManager implements X509TrustManager {
	 private static TrustManager[] trustManagers;
	    private static final X509Certificate[] acceptedIssuers = new X509Certificate[] {};

	    /**
	     * Checks whether the specified certificate chain (partial or complete) can
	     * be validated and is trusted for client authentication for the specified
	     * authentication type.
	     *
	     * @param chain    the certificate chain to validate.
	     * @param authType the authentication type used.
	     * @throws CertificateException     if the certificate chain can't be validated or isn't trusted.
	     * @throws IllegalArgumentException if the specified certificate chain is empty or {@code null},
	     *                                  or if the specified authentication type is {@code null} or an
	     *                                  empty string.
	     */
	    @Override
	    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

	    }

	    /**
	     * Checks whether the specified certificate chain (partial or complete) can
	     * be validated and is trusted for server authentication for the specified
	     * key exchange algorithm.
	     *
	     * @param chain    the certificate chain to validate.
	     * @param authType the key exchange algorithm name.
	     * @throws CertificateException     if the certificate chain can't be validated or isn't trusted.
	     * @throws IllegalArgumentException if the specified certificate chain is empty or {@code null},
	     *                                  or if the specified authentication type is {@code null} or an
	     *                                  empty string.
	     */
	    @Override
	    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

	    }

	    /**
	     * Returns the list of certificate issuer authorities which are trusted for
	     * authentication of peers.
	     *
	     * @return the list of certificate issuer authorities which are trusted for
	     * authentication of peers.
	     */
	    @Override
	    public X509Certificate[] getAcceptedIssuers() {
	        return acceptedIssuers;
	    }

	    public static void allowAllSSL() {
	        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
	            @Override
	            public boolean verify(String hostname, SSLSession session) {
	                return true;
	            }
	        });

	        SSLContext context = null;
	        if (trustManagers == null) {
	            trustManagers = new TrustManager[] {
	                    new HTTPSTrustManager()
	            };
	        }

	        try {
	            context = SSLContext.getInstance("TLS");
	            context.init(null, trustManagers, new SecureRandom());
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } catch (KeyManagementException e) {
	            e.printStackTrace();
	        }

	        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
	    }
}
