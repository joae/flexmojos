/**
 *  Copyright 2008 Marvin Herman Froeder
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 *
 */
package info.rvin.mojo.flexmojo.test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import info.flexmojos.tests.AbstractFlexMojosTests;

import java.io.File;

import org.testng.annotations.Test;

public class IT0015CoverageTest
    extends AbstractFlexMojosTests
{

    public void standardConceptTester( String coverageName )
        throws Exception
    {
        File testDir = getProject( "/coverage/" + coverageName );
        test( testDir, "install" );
    }

    @Test( timeOut = 120000 )
    public void testSourceFileResolver()
        throws Exception
    {
        standardConceptTester( "source-file-resolver" );
    }

    @Test( timeOut = 120000 )
    public void testAsdocInclusionExclusion()
        throws Exception
    {
        File testDir = getProject( "/coverage/asdoc-inclusion-exclusion" );
        test( testDir, "info.flex-mojos:flex-maven-plugin:" + getProperty( "version" ) + ":asdoc" );
        File vermelho = new File( testDir, "target/asdoc/Vermelho.html" );
        assertFalse( "Should not generate Vermelho.html.", vermelho.exists() );
        File amarelo = new File( testDir, "target/asdoc/Amarelo.html" );
        assertFalse( "Should not generate Amarelo.html.", amarelo.exists() );
    }

    @Test( timeOut = 120000 )
    public void testFlexUnitReport()
        throws Exception
    {
        File testDir = getProject( "/concept/flexunit-example" );
        test( testDir, "site:site" );
        File asdoc = new File( testDir, "/target/site/asdoc" );
        assertTrue( asdoc.isDirectory() );
    }

    @Test( timeOut = 120000 )
    public void testHtmlwrapperTemplates()
        throws Exception
    {
        File testDir = getProject( "/coverage/htmlwrapper-templates" );
        test( testDir, "package" );
        File folder = new File( testDir, "folder/target/htmlwrapper-templates-folder-1.0-SNAPSHOT.html" );
        assertTrue( "Should generate htmlwrapper" + folder.getAbsolutePath(), folder.exists() );
        File zip = new File( testDir, "zip/target/htmlwrapper-templates-zip-1.0-SNAPSHOT.html" );
        assertTrue( "Should generate htmlwrapper " + zip.getAbsolutePath(), zip.exists() );
    }

    @Test( timeOut = 120000 )
    public void testDefines()
        throws Exception
    {
        File testDir = getProject( "/issues/issue-0068" );
        test( testDir, "install" );

    }

    @Test( timeOut = 120000 )
    public void testCompilationOptions()
        throws Exception
    {
        standardConceptTester( "compilation-options" );
    }

}
