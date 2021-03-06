// Copyright (C) 2008 - 2011 Philip Aston
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

package net.grinder.common.processidentity;

import net.grinder.communication.Address;


/**
 * Base {@link Address} implementation for a process.
 *
 * @param <T> Process identity type.
 * @author Philip Aston
 */
public abstract class ProcessAddress<T extends ProcessIdentity>
  implements Address {

  private static final long serialVersionUID = 1;

  private final T m_processIdentity;

  /**
   * Constructor.
   *
   * @param processIdentity The agent identity.
   */
  public ProcessAddress(T processIdentity) {
    m_processIdentity = processIdentity;
  }

  /**
   * Whether this address includes the given address.
   *
   * <p>
   * The general <code>includes</code> relationship is transitive, reflexive,
   * and asymmetric. Simple implementations of "physical addresses" should just
   * delegate to equals().
   * </p>
   *
   * @param address
   *            The address to check.
   * @return <code>true</code> if and only if we include <code>address</code>.
   */
  public boolean includes(Address address) {
    return equals(address);
  }

  /**
   * The process identity.
   *
   * @return The process identity.
   */
  public T getIdentity() {
    return m_processIdentity;
  }

  /**
   * Hash code.
   *
   * @return The hash code.
   */
  public int hashCode() {
    return m_processIdentity.hashCode();
  }

  /**
   * Equality.
   *
   * @param o Object to compare.
   * @return <code>true</code> if and only if the given object is equal.
   */
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final ProcessAddress<?> other = (ProcessAddress<?>)o;

    return m_processIdentity.equals(other.m_processIdentity);
  }
}
