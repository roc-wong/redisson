/**
 * Copyright (c) 2013-2019 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.spring.starter.config;

import org.redisson.config.SslProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @param <T> config type
 * @author Nikita Koksharov
 */
public class BaseConfig<T extends BaseConfig<T>> {

    private static final Logger log = LoggerFactory.getLogger("config");

    /**
     * If pooled connection not used for a <code>timeout</code> time and current connections amount
     * bigger than minimum idle connections pool size, then it will closed and removed from pool.
     * Value in milliseconds.
     */
    private int idleConnectionTimeout = 10000;

    /**
     * Ping timeout used in <code>Node.ping</code> and <code>Node.pingAll<code> operation. Value in
     * milliseconds.
     */
    private int pingTimeout = 1000;

    /**
     * Timeout during connecting to any Redis server. Value in milliseconds.
     */
    private int connectTimeout = 10000;

    /**
     * Redis server response timeout. Starts to countdown when Redis command was succesfully sent.
     * Value in milliseconds.
     */
    private int timeout = 3000;

    private int retryAttempts = 3;

    private int reconnectionTimeout = 3000;

    private int retryInterval = 1500;

    /**
     * Password for Redis authentication. Should be null if not needed
     */
    private String password;

    /**
     * Subscriptions per Redis connection limit
     */
    private int subscriptionsPerConnection = 5;

    /**
     * Name of client connection
     */
    private String clientName;

    private boolean sslEnableEndpointIdentification = true;

    private SslProvider sslProvider = SslProvider.JDK;

    private String sslTruststore;

    private String sslTruststorePassword;

    private String sslKeystore;

    private String sslKeystorePassword;

    private int pingConnectionInterval;

    private boolean keepAlive;

    private boolean tcpNoDelay;

    public static Logger getLog() {
        return log;
    }

    public int getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    public void setIdleConnectionTimeout(int idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    public int getPingTimeout() {
        return pingTimeout;
    }

    public void setPingTimeout(int pingTimeout) {
        this.pingTimeout = pingTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSubscriptionsPerConnection() {
        return subscriptionsPerConnection;
    }

    public void setSubscriptionsPerConnection(int subscriptionsPerConnection) {
        this.subscriptionsPerConnection = subscriptionsPerConnection;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public boolean isSslEnableEndpointIdentification() {
        return sslEnableEndpointIdentification;
    }

    public void setSslEnableEndpointIdentification(boolean sslEnableEndpointIdentification) {
        this.sslEnableEndpointIdentification = sslEnableEndpointIdentification;
    }

    public SslProvider getSslProvider() {
        return sslProvider;
    }

    public void setSslProvider(SslProvider sslProvider) {
        this.sslProvider = sslProvider;
    }

    public String getSslTruststorePassword() {
        return sslTruststorePassword;
    }

    public void setSslTruststorePassword(String sslTruststorePassword) {
        this.sslTruststorePassword = sslTruststorePassword;
    }

    public String getSslTruststore() {
        return sslTruststore;
    }

    public void setSslTruststore(String sslTruststore) {
        this.sslTruststore = sslTruststore;
    }

    public String getSslKeystore() {
        return sslKeystore;
    }

    public void setSslKeystore(String sslKeystore) {
        this.sslKeystore = sslKeystore;
    }

    public String getSslKeystorePassword() {
        return sslKeystorePassword;
    }

    public void setSslKeystorePassword(String sslKeystorePassword) {
        this.sslKeystorePassword = sslKeystorePassword;
    }

    public int getPingConnectionInterval() {
        return pingConnectionInterval;
    }

    public void setPingConnectionInterval(int pingConnectionInterval) {
        this.pingConnectionInterval = pingConnectionInterval;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isTcpNoDelay() {
        return tcpNoDelay;
    }

    public void setTcpNoDelay(boolean tcpNoDelay) {
        this.tcpNoDelay = tcpNoDelay;
    }

    public int getReconnectionTimeout() {
        return reconnectionTimeout;
    }

    public void setReconnectionTimeout(int reconnectionTimeout) {
        this.reconnectionTimeout = reconnectionTimeout;
    }
}
