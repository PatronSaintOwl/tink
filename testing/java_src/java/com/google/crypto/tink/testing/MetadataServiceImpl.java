// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
////////////////////////////////////////////////////////////////////////////////

package com.google.crypto.tink.testing;

import com.google.crypto.tink.Version;
import com.google.crypto.tink.proto.testing.MetadataGrpc.MetadataImplBase;
import com.google.crypto.tink.proto.testing.ServerInfo;
import com.google.crypto.tink.proto.testing.ServerInfoRequest;
import io.grpc.stub.StreamObserver;
import java.security.GeneralSecurityException;

/** Implement a gRPC service for the server's metadata. */
public final class MetadataServiceImpl extends MetadataImplBase {

  public MetadataServiceImpl() throws GeneralSecurityException {
  }

  @Override
  public void getServerInfo(
      ServerInfoRequest request, StreamObserver<ServerInfo> responseObserver) {
    ServerInfo response;
    response =
        ServerInfo.newBuilder()
            .setLanguage("java")
            .setTinkVersion(Version.TINK_VERSION)
            .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
