/**
 * Copyright (c) 2010-2015, openHAB.org and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.sonance;

import org.openhab.core.binding.BindingProvider;

/**
 * @author Laurens Van Acker
 * @since 1.8.0
 */
public interface SonanceBindingProvider extends BindingProvider {
	public String getIP(String itemName);

	public int getPort(String itemName);

	public String getGroup(String itemName);

	public Boolean isMute(String itemName);

	public Boolean isVolume(String itemName);
}
