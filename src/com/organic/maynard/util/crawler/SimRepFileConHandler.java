/*
 * Copyright (c) 2001, Maynard Demmon
 * Copyright (c) 2001, Organic
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 *
 *  - Redistributions of source code must retain the above copyright notice, this 
 *    list of conditions and the following disclaimer.
 * 
 *  - Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution. 
 *
 *  - Neither the name of Organic nor the names of its contributors may 
 *    be used to endorse or promote products derived from this software without 
 *    specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */

package com.organic.maynard.util.crawler;

import com.organic.maynard.util.string.StringTools;

public class SimRepFileConHandler extends FileContentsHandler {

	// Declare Fields
	private String match = null;
	private String replacement = null;
	
	
	// Constructors
	public SimRepFileConHandler(String match, String replacement, String lineEnding) {
		super(lineEnding);
		setMatch(match);
		setReplacement(replacement);
	}


	// Accessors
	public String getMatch() {return match;}
	public void setMatch(String match) {this.match = match;}

	public String getReplacement() {return replacement;}
	public void setReplacement(String replacement) {this.replacement = replacement;}
	
	
	// Overridden Methods
	protected String processContents(String contents) {
		return StringTools.replace(contents, match, replacement);
	}	
}