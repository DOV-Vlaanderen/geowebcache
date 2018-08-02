/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package org.geowebcache.s3;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import io.findify.s3mock.S3Mock;

/**
 * Offline integration tests for {@link S3BlobStore}.
 * <p>
 */
public class OfflineS3BlobStoreIntegrationTest extends AbstractS3BlobStoreIntegrationTest {

    private static S3Mock api;
    
    @BeforeClass
    public static void beforeClass() {
        api = new S3Mock.Builder().withPort(8001).withInMemoryBackend().build();
        api.start();
    }
    
    @AfterClass
    public static void afterClass() {
        api.stop();
    }
    
    protected S3BlobStoreConfig getConfiguration() {
        S3BlobStoreConfig config = new S3BlobStoreConfig();
        config.setEndpoint("http://localhost:8001");
        config.setBucket("testbucket");
        return config;
    }
}
