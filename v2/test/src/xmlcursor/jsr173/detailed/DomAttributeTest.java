/*   Copyright 2004 The Apache Software Foundation
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package xmlcursor.jsr173.detailed;


import junit.framework.*;
import xmlcursor.jsr173.common.AttributeTest;

import javax.xml.stream.XMLStreamReader;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.impl.newstore2.Public2;
import org.w3c.dom.Node;
/**
 *
 * @status inactive
 */
public  class DomAttributeTest
        extends AttributeTest {


    public DomAttributeTest(String s) {
        super(s);
    }
    public  XMLStreamReader getStream(XmlCursor c)
    throws Exception{
        String xml=c.xmlText();
        Node dom=Public2.parse(xml);//c.newDomNode();
        //brutal hack since we can't get dom from the cursor and need
        //to go via the saver
        if (xml.startsWith("<xml-frag")){
        dom=dom.getFirstChild();
        dom=dom.getAttributes().item(0); }
        return Public2.getStream(dom);
    }

      public static Test suite() {
        return new TestSuite(DomAttributeTest.class);
    }

}