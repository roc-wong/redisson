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
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Nikita Koksharov
 */
public class ClusterServersConfig extends BaseMasterSlaveServersConfig<ClusterServersConfig> {

    private Map<String, String> natMap = Collections.emptyMap();

    /**
     * Redis cluster node urls list
     */
    private List<String> nodeAddresses = new ArrayList<>();

    /**
     * Redis cluster scan interval in milliseconds
     */
    private int scanInterval = 5000;

    public Map<String, String> getNatMap() {
        return natMap;
    }

    /**
     * Defines NAT mapping. Address as a map key is replaced with mapped address as value.
     *
     * @param natMap - nat mapping
     */
    public void setNatMap(Map<String, String> natMap) {
        this.natMap = natMap;
    }

    public List<String> getNodeAddresses() {
        return nodeAddresses;
    }

    public void setNodeAddresses(List<String> nodeAddresses) {
        this.nodeAddresses = nodeAddresses;
    }

    public int getScanInterval() {
        return scanInterval;
    }

    /**
     * Redis cluster scan interval in milliseconds
     * <p>
     * Default is <code>5000</code>
     *
     * @param scanInterval in milliseconds
     */
    public void setScanInterval(int scanInterval) {
        this.scanInterval = scanInterval;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClusterServersConfig{");
        sb.append("natMap=").append(natMap);
        sb.append(", nodeAddresses=").append(nodeAddresses);
        sb.append(", scanInterval=").append(scanInterval);
        sb.append('}');
        return sb.toString();
    }
}
