// Copyright (C) 2003 - 2011 Philip Aston
// Copyright (C) 2005 Martin Wagner
// All rights reserved.
//
// This file is part of The Grinder software distribution. Refer to
// the file LICENSE which is part of The Grinder distribution for
// licensing details. The Grinder distribution is available on the
// Internet at http://grinder.sourceforge.net/
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
// FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
// COPYRIGHT HOLDERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
// INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
// (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
// SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
// HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
// STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
// OF THE POSSIBILITY OF SUCH DAMAGE.

package org.python.core;


/**
 * A {@code PyInstance} that shares the same class, dictionary, and
 * (optional) Java Proxy as another. {@code ClonePyInstance} is sub-classed
 * by {@link
 * net.grinder.scriptengine.jython.instrumentation.traditional.InstrumentedPyInstance}
 * which customises the invocation behaviour and becomes the "wrapped" object
 * for Python classes. It is in the {@code org.python.core} package so that
 * it can access the {@code javaProxy} field.
 *
 * @author Philip Aston
 */
public class ClonePyInstance extends PyInstance {

  private final PyInstance m_target;

  /**
   * Constructor.
   *
   * @param targetClass The target class.
   * @param target The target instance.
   */
  public ClonePyInstance(PyClass targetClass, PyInstance target) {
    super(targetClass, target.__dict__);

    javaProxy = target.javaProxy;

    // Keep a reference to the target so it doesn't get gc'd until we
    // do.
    m_target = target;
  }

  /**
   * Return the target instance.
   *
   * @return Th etarget instance.
   */
  protected final PyInstance getTarget() {
    return m_target;
  }
}

