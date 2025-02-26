/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.xwiki.repository.internal.resources;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.xwiki.component.annotation.Component;
import org.xwiki.extension.repository.xwiki.model.jaxb.Extension;
import org.xwiki.query.QueryException;
import org.xwiki.repository.Resources;

import com.xpn.xwiki.XWikiException;
import com.xpn.xwiki.doc.XWikiDocument;

/**
 * @version $Id$
 * @since 3.2M3
 */
@Component
@Named("org.xwiki.repository.internal.resources.ExtensionRESTResource")
@Path(Resources.EXTENSION)
public class ExtensionRESTResource extends AbstractExtensionRESTResource
{
    @GET
    public Extension getExtension(@PathParam("extensionId") String extensionId) throws XWikiException, QueryException
    {
        XWikiDocument extensionDocument = getExistingExtensionDocumentById(extensionId);

        checkRights(extensionDocument);

        return createExtension(extensionDocument, null);
    }
}
