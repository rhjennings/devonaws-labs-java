/** 
 * Copyright 2013 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not 
 * use this file except in compliance with the License. A copy of the License 
 * is located at
 * 
 * 	http://aws.amazon.com/apache2.0/
 * 
 * or in the "LICENSE" file accompanying this file. This file is distributed 
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package awslabs.lab51;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amazonaws.internal.EC2MetadataClient;
import com.amazonaws.util.json.JSONException;
import com.amazonaws.util.json.JSONObject;

/**
 * Project: Lab5.1
 */
public class Lab51 {
	private static ILabCode labCode = new StudentCode();
	private static IOptionalLabCode optionalLabCode = new StudentCode();
	
	private List<String> StatusLog = new ArrayList<String>();
	private List<String> ImageListRows = new ArrayList<String>();
	private List<String> ImageNames = new ArrayList<String>();
	
	public Lab51() {
		// Add our images to the list.
		ImageNames.add("icons\\dynamodb.png");
		ImageNames.add("icons\\ec2.png");
		ImageNames.add("icons\\elasticbeanstalk.png");
		ImageNames.add("icons\\iam.png");
		ImageNames.add("icons\\s3.png");
		ImageNames.add("icons\\sqs.png");
        // DECOY IMAGE
		ImageNames.add("decoy\\decoy.png");
	}
	
	String getConfigAsHtml() {
		return "";
	}
	
	String getSysEnvAsHtml() {
		return "";
	}
	
	String getImageListAsHtml() {
		return "";
	}
	
	String getStatusAsHtml() {
		return "";
	}
	
    /// <summary>
    ///     Store a message to be logged to the screen when the page renders.
    /// </summary>
    /// <param name="message">The message to log.</param>
    public void logMessageToPage(String message)
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy THH:mm:ss.SS");
        StatusLog.add(String.format("[<i>{0:MM/dd/yy H:mm:ss.ff}</i>] %s", sdf.format(new Date()), message));
    }
    
    /// <summary>
    ///     Store a message to be logged to the screen when the page renders.
    /// </summary>
    /// <param name="format">The format string.</param>
    /// <param name="args">The values to show in the formatted string.</param>
    public void logMessageToPage(String format, Object... args)
    {
        logMessageToPage(String.format(format, args));
    }
    
    public void addImageToPage(String url, String bucket, String key) {
    	StringBuilder sb = new StringBuilder();
        sb.append("<div class=\"imageblock\"><table><tr>");
        sb.append("<td><img src=\"" + url + "\" /></td>");
        sb.append("<td><table>");
        sb.append("<tr><td><b>Bucket:</b></td><td>" + bucket + "</td></tr>");
        sb.append("<tr><td><b>Key:</b></td><td>" + key + "</td></tr>");
        sb.append("</table></td></tr></table></div>");
        ImageListRows.add(sb.toString());
    }
    
    private void getInstanceIdentityMetadata() throws IOException, JSONException {
    	String credentialsResponse = new EC2MetadataClient().getDefaultCredentials();
    	JSONObject jsonObject = new JSONObject(credentialsResponse);
    }
}
