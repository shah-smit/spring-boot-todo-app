

package com.yourname.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "App User Not Found")
public class AppUserNotFoundException extends Exception {
    // ...
}
