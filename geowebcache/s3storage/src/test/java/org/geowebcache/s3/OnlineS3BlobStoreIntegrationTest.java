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

import org.junit.Assume;
import org.junit.Rule;

/**
 * Online integration tests for {@link S3BlobStore}.
 * <p>
 * For the tests to be run, a properties file {@code $HOME/.gwc_s3_tests.properties} must exist and
 * contain entries for {@code bucket}, {@code accessKey}, and {@code secretKey}.
 */
public class OnlineS3BlobStoreIntegrationTest extends AbstractS3BlobStoreIntegrationTest {

    @Rule
    public TemporaryS3Folder tempFolder = new TemporaryS3Folder(testConfigLoader.getProperties());
    
    protected S3BlobStoreConfig getConfiguration() {
        Assume.assumeTrue(tempFolder.isConfigured());
        return tempFolder.getConfig();
        
    }
}
