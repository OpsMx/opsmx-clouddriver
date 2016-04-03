/*
 * Copyright 2016 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.clouddriver.cache

import com.netflix.appinfo.InstanceInfo
import com.netflix.discovery.DiscoveryClient
import com.netflix.spinnaker.cats.redis.cluster.NodeStatusProvider

class EurekaStatusNodeStatusProvider implements NodeStatusProvider {
  private final DiscoveryClient discoveryClient;

  EurekaStatusNodeStatusProvider(DiscoveryClient discoveryClient) {
    this.discoveryClient = discoveryClient
  }

  @Override
  boolean isNodeEnabled() {
    discoveryClient.instanceRemoteStatus == InstanceInfo.InstanceStatus.UP
  }
}
