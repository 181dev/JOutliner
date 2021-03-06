/**
 * Copyright (C) 2000, 2001 Maynard Demmon, maynard@organic.com
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or 
 * without modification, are permitted provided that the 
 * following conditions are met:
 * 
 *  - Redistributions of source code must retain the above copyright 
 *    notice, this list of conditions and the following disclaimer. 
 * 
 *  - Redistributions in binary form must reproduce the above 
 *    copyright notice, this list of conditions and the following 
 *    disclaimer in the documentation and/or other materials provided 
 *    with the distribution. 
 * 
 *  - Neither the names "Java Outline Editor", "JOE" nor the names of its 
 *    contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT 
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS 
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE 
 * COPYRIGHT HOLDERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; 
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
 
package com.organic.maynard.outliner.util.preferences;

import com.organic.maynard.outliner.guitree.*;
import org.xml.sax.*;

public class PreferenceBoolean extends AbstractPreference implements GUITreeComponent {
	
	// Instance Fields
	public boolean def = false;
	public boolean cur = false;
	public boolean tmp = false;

	
	// Constructors
	public PreferenceBoolean() {}
	
	public PreferenceBoolean(boolean def, String command) {
		this(def,false,command);
	}

	public PreferenceBoolean(boolean def, boolean cur, String command, BooleanValidator validator) {
		this(def,cur,command);
		setValidator(validator);
	}

	public PreferenceBoolean(boolean def, boolean cur, String command) {
		this.def = def;
		this.cur = cur;
		this.tmp = cur;
		setCommand(command);
	}


	// GUITreeComponent Interface
        @Override
	public void endSetup(Attributes atts) {
		super.endSetup(atts);
	}	


	// Setters with Validation
        @Override
	public void setDef(String value) {this.def = ((Boolean) getValidator().getValidValue(value)).booleanValue();}
	public void setDef(boolean value) {this.def = value;}

        @Override
	public void setCur(String value) {this.cur = ((Boolean) getValidator().getValidValue(value)).booleanValue();}
	public void setCur(boolean value) {this.cur = value;}

        @Override
	public void setTmp(String value) {this.tmp = ((Boolean) getValidator().getValidValue(value)).booleanValue();}
	public void setTmp(boolean value) {this.tmp = value;}

        @Override
	public String getCur() {return String.valueOf(cur);}
        @Override
	public String getDef() {return String.valueOf(def);}
        @Override
	public String getTmp() {return String.valueOf(tmp);}

	// Misc Methods
        @Override
	public String toString() {return String.valueOf(cur);}

	
	// Preference Interface
        @Override
	public void restoreCurrentToDefault() {cur = def;}
        @Override
	public void restoreTemporaryToDefault(){tmp = def;}
        @Override
	public void restoreTemporaryToCurrent(){tmp = cur;}
        @Override
	public void applyTemporaryToCurrent(){cur = tmp;}
}