package com.github.kongchen.swagger.docgen.helpers;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

import java.io.IOException;

/**
 * @author AD82225
 * @version 11082015
 */
public enum HandlebarHelpers implements Helper<Object> {

    after {
        @Override
        public CharSequence apply(Object o, Options options) throws IOException {
            String separator = options.param(0);
            int beginningIndex = options.param(1, 0);
            int endingIndex = options.param(2, -1);

            String retValue = o.toString();
            retValue = retValue.substring(retValue.indexOf(separator, beginningIndex), retValue.indexOf(separator, endingIndex));
            if (endingIndex < 0) {
                return retValue.substring(retValue.indexOf(separator, beginningIndex));
            }
            return retValue.substring(retValue.indexOf(separator, beginningIndex), retValue.indexOf(separator, endingIndex));
        }
    }

}
