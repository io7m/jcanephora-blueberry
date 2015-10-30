/*
 * Copyright © 2015 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.jcanephora.blueberry;

import com.io7m.blueberry.TestReportConfig;
import com.io7m.blueberry.gui.GUI;
import com.io7m.blueberry.gui.GUIProjectInfo;
import com.io7m.blueberry.gui.GUIProjectVersion;
import com.io7m.junreachable.UnreachableCodeException;

import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.net.URI;

/**
 * The main frontend.
 */

public final class Main
{
  private Main()
  {
    throw new UnreachableCodeException();
  }

  /**
   * The main entry point.
   *
   * @param args Command line arguments
   */

  public static void main(final String[] args)
  {
    final GUIProjectVersion version =
      new GUIProjectVersion(0, 40, 0, "SNAPSHOT");
    final GUIProjectInfo info = new GUIProjectInfo("jcanephora", version);
    final TestReportConfig report_config = info.getReportConfig();
    report_config.setOutputEnvironment(true);
    report_config.setOutputSystemProperties(true);

    info.addPackagePrefix("com.io7m.jcanephora");
    info.setProjectURI(URI.create("http://io7m.github.io/jcanephora"));

    SwingUtilities.invokeLater(
      () -> {
        final GUI g = new GUI(info);
        g.getMainWindow()
          .setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      });
  }
}
