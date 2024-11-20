/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;



/**
 * @author jpereira
 *
 */

public class WordCensor extends SocialChannelDecorator {

    private static final String[] FORBIDDEN_WORDS = { "Bill", "Gates", "Microsoft" };

    public WordCensor() {
    }

    @Override
    public void deliverMessage(String message) {
        String censoredMessage = message;
        for (String forbiddenWord : FORBIDDEN_WORDS) {
            String replacement = "";
            for (int i = 0; i < forbiddenWord.length(); i++) {
                replacement += "*";
            }
            censoredMessage = censoredMessage.replaceAll(forbiddenWord, replacement);
        }
        if(delegate != null) {
            delegate.deliverMessage(censoredMessage);
        }
    }
}
