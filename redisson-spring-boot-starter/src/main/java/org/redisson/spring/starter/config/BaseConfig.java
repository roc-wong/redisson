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

    /**
     * If pooled connection not used for a <code>timeout</code> time
     * and current connections amount bigger than minimum idle connections pool size,
     * then it will closed and removed from pool.
     *
     * @param idleConnectionTimeout - timeout in milliseconds
     */
    public void setIdleConnectionTimeout(int idleConnectionTimeout) {
        this.idleConnectionTimeout = idleConnectionTimeout;
    }

    public int getPingTimeout() {
        return pingTimeout;
    }

    @Deprecated
    public void setPingTimeout(int pingTimeout) {
        this.pingTimeout = pingTimeout;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Timeout during connecting to any Redis server.
     * <p>
     * Default is <code>10000</code> milliseconds.
     *
     * @param connectTimeout - timeout in milliseconds
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getTimeout() {
        return timeout;
    }

    /**
     * Redis server response timeout. Starts to countdown when Redis command has been successfully sent.
     * <p>
     * Default is <code>3000</code> milliseconds
     *
     * @param timeout in milliseconds
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }

    /**
     * Error will be thrown if Redis command can't be sent to Redis server after <code>retryAttempts</code>.
     * But if it sent successfully then <code>timeout</code> will be started.
     * <p>
     * Default is <code>3</code> attempts
     *
     * @see #timeout
     * @param retryAttempts - retry attempts
     */
    public void setRetryAttempts(int retryAttempts) {
        this.retryAttempts = retryAttempts;
    }

    public int getRetryInterval() {
        return retryInterval;
    }

    /**
     * Defines time interval for another one attempt send Redis command
     * if it hasn't been sent already.
     *
     * <p>
     * Default is <code>1500</code> milliseconds
     *
     * @see #retryAttempts
     * @param retryInterval - time in milliseconds
     */
    public void setRetryInterval(int retryInterval) {
        this.retryInterval = retryInterval;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Password for Redis authentication. Should be null if not needed
     * Default is <code>null</code>
     *
     * @param password for connection
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public int getSubscriptionsPerConnection() {
        return subscriptionsPerConnection;
    }

    /**
     * Subscriptions per Redis connection limit
     * Default is 5
     *
     * @param subscriptionsPerConnection amount
     */
    public void setSubscriptionsPerConnection(int subscriptionsPerConnection) {
        this.subscriptionsPerConnection = subscriptionsPerConnection;
    }

    public String getClientName() {
        return clientName;
    }

    /**
     * Setup connection name during connection init
     * via CLIENT SETNAME command
     *
     * @param clientName - name of client
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public boolean isSslEnableEndpointIdentification() {
        return sslEnableEndpointIdentification;
    }

    /**
     * Enables SSL endpoint identification.
     * <p>
     * Default is <code>true</code>
     *
     * @param sslEnableEndpointIdentification - boolean value
     */
    public void setSslEnableEndpointIdentification(boolean sslEnableEndpointIdentification) {
        this.sslEnableEndpointIdentification = sslEnableEndpointIdentification;
    }

    public SslProvider getSslProvider() {
        return sslProvider;
    }

    /**
     * Defines SSL provider used to handle SSL connections.
     * <p>
     * Default is JDK
     *
     * @param sslProvider - ssl provider
     */
    public void setSslProvider(SslProvider sslProvider) {
        this.sslProvider = sslProvider;
    }

    public String getSslTruststorePassword() {
        return sslTruststorePassword;
    }

    /**
     * Defines password for SSL truststore
     *
     * @param sslTruststorePassword - password
     */
    public void setSslTruststorePassword(String sslTruststorePassword) {
        this.sslTruststorePassword = sslTruststorePassword;
    }

    public String getSslTruststore() {
        return sslTruststore;
    }

    /**
     * Defines path to SSL truststore
     *
     * @param sslTruststore - path
     */
    public void setSslTruststore(String sslTruststore) {
        this.sslTruststore = sslTruststore;
    }

    public String getSslKeystore() {
        return sslKeystore;
    }

    /**
     * Defines path to SSL keystore
     *
     * @param sslKeystore - path to keystore
     */
    public void setSslKeystore(String sslKeystore) {
        this.sslKeystore = sslKeystore;
    }

    public String getSslKeystorePassword() {
        return sslKeystorePassword;
    }

    /**
     * Defines password for SSL keystore
     *
     * @param sslKeystorePassword - password
     */
    public void setSslKeystorePassword(String sslKeystorePassword) {
        this.sslKeystorePassword = sslKeystorePassword;
    }

    public int getPingConnectionInterval() {
        return pingConnectionInterval;
    }

    /**
     * Defines PING command sending interval per connection to Redis.
     * <code>0</code> means disable.
     * <p>
     * Default is <code>0</code>
     *
     * @param pingConnectionInterval - time in milliseconds
     */
    public void setPingConnectionInterval(int pingConnectionInterval) {
        this.pingConnectionInterval = pingConnectionInterval;
    }

    public boolean isKeepAlive() {
        return keepAlive;
    }

    /**
     * Enables TCP keepAlive for connection
     * <p>
     * Default is <code>false</code>
     *
     * @param keepAlive - boolean value
     */
    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isTcpNoDelay() {
        return tcpNoDelay;
    }

    /**
     * Enables TCP noDelay for connection
     * <p>
     * Default is <code>false</code>
     *
     * @param tcpNoDelay - boolean value
     */
    public void setTcpNoDelay(boolean tcpNoDelay) {
        this.tcpNoDelay = tcpNoDelay;
    }

    /**
     * Use {@link BaseMasterSlaveServersConfig#setFailedSlaveReconnectionInterval(int)} instead
     * @param reconnectionTimeout
     */
    @Deprecated
    public void setReconnectionTimeout(int reconnectionTimeout) {
        log.warn("'reconnectionTimeout' setting in unavailable. Please use 'failedSlaveReconnectionInterval' setting instead!");
    }

    /**
     * Use {@link BaseMasterSlaveServersConfig#setFailedSlaveCheckInterval(int)} instead
     */
    @Deprecated
    public void setFailedAttempts(int slaveFailedAttempts) {
        log.warn("'failedAttempts' setting in unavailable. Please use 'failedSlaveCheckInterval' setting instead!");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseConfig{");
        sb.append("idleConnectionTimeout=").append(idleConnectionTimeout);
        sb.append(", pingTimeout=").append(pingTimeout);
        sb.append(", connectTimeout=").append(connectTimeout);
        sb.append(", timeout=").append(timeout);
        sb.append(", retryAttempts=").append(retryAttempts);
        sb.append(", retryInterval=").append(retryInterval);
        sb.append(", password='").append(password).append('\'');
        sb.append(", subscriptionsPerConnection=").append(subscriptionsPerConnection);
        sb.append(", clientName='").append(clientName).append('\'');
        sb.append(", sslEnableEndpointIdentification=").append(sslEnableEndpointIdentification);
        sb.append(", sslProvider=").append(sslProvider);
        sb.append(", sslTruststore='").append(sslTruststore).append('\'');
        sb.append(", sslTruststorePassword='").append(sslTruststorePassword).append('\'');
        sb.append(", sslKeystore='").append(sslKeystore).append('\'');
        sb.append(", sslKeystorePassword='").append(sslKeystorePassword).append('\'');
        sb.append(", pingConnectionInterval=").append(pingConnectionInterval);
        sb.append(", keepAlive=").append(keepAlive);
        sb.append(", tcpNoDelay=").append(tcpNoDelay);
        sb.append('}');
        return sb.toString();
    }
}
