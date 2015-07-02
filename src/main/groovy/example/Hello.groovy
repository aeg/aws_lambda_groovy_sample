package example

import com.amazonaws.services.lambda.runtime.Context

public class Hello {
    public String myHandler(int myCount, Context context) {
        def logger = context.logger()
        logger.log("received: ${myCount*2}\n")
        myCount.toString()
    }
}