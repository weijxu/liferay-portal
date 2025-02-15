/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

Path projectPath = Paths.get(request.outputDirectory, request.artifactId)

Path buildGradlePath = projectPath.resolve("build.gradle")

Files.deleteIfExists buildGradlePath

def buildDir = projectPath.toFile()

def webINFDir = new File(buildDir, "src/main/webapp/WEB-INF")

String liferayVersion = request.properties.get("liferayVersion")

char minorVersion = liferayVersion.charAt(2)

File liferayDisplayXML = new File(
	webINFDir, "liferay-display.xml");

File liferayPortletXML = new File(
	webINFDir, "liferay-portlet.xml");

def newLiferayDisplayContent = liferayDisplayXML.text.replace("7.0", "7." + minorVersion).replace("7_0", "7_" + minorVersion)

liferayDisplayXML.text = newLiferayDisplayContent

def newLiferayPortletContent = liferayPortletXML.text.replace("7.0", "7." + minorVersion).replace("7_0", "7_" + minorVersion)

liferayPortletXML.text = newLiferayPortletContent