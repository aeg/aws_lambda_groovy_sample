package example

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.events.S3Event
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.event.S3EventNotification
import com.amazonaws.services.s3.model.GetObjectRequest
import com.amazonaws.services.s3.model.S3Object

public class S3Sample {
    public String handleRequest(S3Event s3event, Context context) {
        S3EventNotification.S3EventNotificationRecord record = s3event.records.get(0)

        String srcBucket = record.s3.bucket.name
        // Object key may have spaces or unicode non-ASCII characters.
        String srcKey = record.getS3().getObject().key.replace('+', ' ')
        srcKey = URLDecoder.decode(srcKey, "UTF-8")

        AmazonS3 s3Client = new AmazonS3Client()
        S3Object s3Object= s3Client.getObject(new GetObjectRequest(srcBucket, srcKey))

        def logger = context.logger
        logger.log("srcBucket: " + srcBucket + "/" + srcKey + "/"
        + s3Object.objectMetadata.contentType)

        "OK"
    }
}
