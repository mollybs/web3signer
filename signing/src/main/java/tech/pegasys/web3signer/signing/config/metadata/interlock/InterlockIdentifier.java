/*
 * Copyright 2020 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package tech.pegasys.web3signer.signing.config.metadata.interlock;

import tech.pegasys.web3signer.signing.config.metadata.InterlockSigningMetadata;

import java.net.URI;
import java.util.Objects;

public class InterlockIdentifier {
  private final URI interlockUrl;
  private final String volume;
  private final String password;

  public static InterlockIdentifier fromMetadata(final InterlockSigningMetadata metadata) {
    return new InterlockIdentifier(
        metadata.getInterlockUrl(), metadata.getVolume(), metadata.getPassword());
  }

  private InterlockIdentifier(final URI interlockUrl, final String volume, final String password) {
    this.interlockUrl = interlockUrl;
    this.volume = volume;
    this.password = password;
  }

  public URI getInterlockUrl() {
    return interlockUrl;
  }

  public String getVolume() {
    return volume;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    final InterlockIdentifier that = (InterlockIdentifier) o;
    return interlockUrl.equals(that.interlockUrl)
        && volume.equals(that.volume)
        && password.equals(that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(interlockUrl, volume, password);
  }
}
