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

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for an Azure Redis Cache or AWS ElastiCache servers. 
 * A replication group is composed of a single master endpoint and multiple read slaves.
 *
 * @author Steve Ungerer
 * @author Nikita Koksharov
 */
public class ReplicatedServersConfig extends BaseMasterSlaveServersConfig<ReplicatedServersConfig> {

    /**
     * Replication group node urls list
     */
    private List<String> nodeAddresses = new ArrayList<>();

    /**
     * Replication group scan interval in milliseconds
     */
    private int scanInterval = 1000;

    /**
     * Database index used for Redis connection
     */
    private int database = 0;


    public List<String> getNodeAddresses() {
        return nodeAddresses;
    }

    /**
     * Add Redis cluster node address. Use follow format -- <code>host:port</code>
     *
     * @param nodeAddresses in <code>host:port</code> format
     */
    public void setNodeAddresses(List<String> nodeAddresses) {
        this.nodeAddresses = nodeAddresses;
    }

    public int getScanInterval() {
        return scanInterval;
    }

    /**
     * Replication group scan interval in milliseconds
     *
     * @param scanInterval in milliseconds
     */
    public void setScanInterval(int scanInterval) {
        this.scanInterval = scanInterval;
    }

    public int getDatabase() {
        return database;
    }

    /**
     * Database index used for Redis connection
     * Default is <code>0</code>
     *
     * @param database number
     */
    public void setDatabase(int database) {
        this.database = database;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReplicatedServersConfig{");
        sb.append("nodeAddresses=").append(nodeAddresses);
        sb.append(", scanInterval=").append(scanInterval);
        sb.append(", database=").append(database);
        sb.append('}');
        return sb.toString();
    }
}
