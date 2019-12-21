/**
 *  Up Down Dimmer
 *
 *  Copyright 2019 Jerzy Mikucki
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
definition(
    name: "Up Down Dimmer",
    namespace: "mikuslaw",
    author: "Jerzy Mikucki",
    description: "Provides an easy way to control a dimmer with two push buttons.",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience@2x.png") {
    appSetting "Step"
}


preferences {
	section("Title") {
    	input "dimmerControlled", "capability.switchLevel"
        input "buttonUpController", "capability.button"
        input "buttonDownController", "capability.button"
	}
}

def installed() {
	log.debug "Installed with settings: ${settings}"

	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
	subscribe(buttonUpController, "button.pushed", upHandler)
    subscribe(buttonDownController, "button.pushed", downHandler)
	
}

def upHandler(evt) {
	log.debug "Up pushed."
}

def downHandler(evt) {
	log.debug "Down pushed."
}

// TODO: implement event handlers