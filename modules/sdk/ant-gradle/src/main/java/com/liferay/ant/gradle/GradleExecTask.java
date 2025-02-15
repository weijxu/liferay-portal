/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.ant.gradle;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.ExecTask;
import org.apache.tools.ant.taskdefs.condition.Os;
import org.apache.tools.ant.types.Commandline;
import org.apache.tools.ant.types.Environment;

/**
 * @author Chas Austin
 * @author Andrea Di Giorgi
 */
public class GradleExecTask extends ExecTask {

	@Override
	public void execute() throws BuildException {
		_addArguments();
		_addEnvironment();

		super.execute();
	}

	@Override
	public void init() throws BuildException {
		super.init();

		try {
			setExecutable(_getExecutable());
		}
		catch (Exception exception) {
			throw new BuildException(exception);
		}

		setFailonerror(true);
	}

	public void setBuildFile(File buildFile) {
		_buildFile = buildFile;
	}

	public void setDaemonDisabled(boolean daemonDisabled) {
		_daemonDisabled = daemonDisabled;
	}

	public void setInheritAntOpts(boolean inheritAntOpts) {
		_inheritAntOpts = inheritAntOpts;
	}

	public void setParallel(boolean parallel) {
		_parallel = parallel;
	}

	public void setProjectCacheDir(File projectCacheDir) {
		_projectCacheDir = projectCacheDir;
	}

	public void setQuiet(boolean quiet) {
		_quiet = quiet;
	}

	public void setStacktrace(boolean stacktrace) {
		_stacktrace = stacktrace;
	}

	public void setTask(String task) {
		if (!_tasks.isEmpty()) {
			throw new BuildException(
				"The \"task\" and \"tasks\" attributes cannot both be " +
					"specified");
		}

		_task = task;
	}

	public void setTasks(String tasks) {
		if ((_task != null) && !_task.isEmpty()) {
			throw new BuildException(
				"The \"task\" and \"tasks\" attributes cannot both be " +
					"specified");
		}

		_tasks.clear();

		StringTokenizer stringTokenizer = new StringTokenizer(tasks, ", ");

		while (stringTokenizer.hasMoreTokens()) {
			_tasks.add(stringTokenizer.nextToken());
		}
	}

	protected Commandline.Argument addArgument(String value) {
		Commandline.Argument argument = createArg();

		argument.setValue(value);

		return argument;
	}

	private void _addArguments() {
		if (_buildFile != null) {
			addArgument("--build-file");
			addArgument(_buildFile.getAbsolutePath());
		}

		if (_daemonDisabled) {
			addArgument("--no-daemon");
		}

		if (_parallel) {
			addArgument("--parallel");
		}

		if (_projectCacheDir != null) {
			addArgument("--project-cache-dir");
			addArgument(_projectCacheDir.getAbsolutePath());
		}

		if (_quiet) {
			addArgument("--quiet");
		}

		if (_stacktrace) {
			addArgument("--stacktrace");
		}

		if ((_task != null) && !_task.isEmpty()) {
			addArgument(_task);
		}
		else {
			for (String task : _tasks) {
				addArgument(task);
			}
		}
	}

	private void _addEnvironment() {
		String antOpts = System.getenv("ANT_OPTS");

		if (_inheritAntOpts && (antOpts != null) && !antOpts.isEmpty()) {
			Environment.Variable variable = new Environment.Variable();

			variable.setKey("GRADLE_OPTS");
			variable.setValue(antOpts);
		}
	}

	private String _getExecutable() throws Exception {
		Project project = getProject();

		String fileName = "gradlew";

		if (Os.isFamily(Os.FAMILY_WINDOWS)) {
			fileName += ".bat";
		}

		File dir = project.getBaseDir();

		while (dir != null) {
			File file = new File(dir, fileName);

			if (file.isFile()) {
				return file.getAbsolutePath();
			}

			dir = dir.getParentFile();
		}

		return null;
	}

	private File _buildFile;
	private boolean _daemonDisabled = true;
	private boolean _inheritAntOpts = true;
	private boolean _parallel = true;
	private File _projectCacheDir;
	private boolean _quiet;
	private boolean _stacktrace = true;
	private String _task;
	private final List<String> _tasks = new ArrayList<String>();

}