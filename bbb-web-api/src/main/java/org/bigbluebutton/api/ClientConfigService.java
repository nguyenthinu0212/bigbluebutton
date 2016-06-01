/**
* BigBlueButton open source conferencing system - http://www.bigbluebutton.org/
* 
* Copyright (c) 2012 BigBlueButton Inc. and by respective authors (see below).
*
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License as published by the Free Software
* Foundation; either version 3.0 of the License, or (at your option) any later
* version.
* 
* BigBlueButton is distributed in the hope that it will be useful, but WITHOUT ANY
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
* PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License along
* with BigBlueButton; if not, see <http://www.gnu.org/licenses/>.
*
*/

package org.bigbluebutton.api;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientConfigService {
	private static Logger log = LoggerFactory.getLogger(ClientConfigService.class);
	
	private String configDir = "/var/bigbluebutton/configs";
  private IClientConfigServiceHelper helper;

  private Map<String, String> configs = new HashMap<String, String>();
  
  public void init() {
  	configs = getAllConfigs();
  }
  
  public String getConfig(String id) {
  	return configs.get(id);
  }
  
	private Map<String, String> getAllConfigs(){
		return helper.getPreBuiltConfigs(configDir);
	}
		
	public void setConfigDir(String dir) {
		configDir = dir;
	}
	
	public void setClientConfigServiceHelper(IClientConfigServiceHelper r) {
		helper = r;
	} 
	
}
