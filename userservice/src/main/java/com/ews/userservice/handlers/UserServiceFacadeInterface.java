package com.ews.userservice.handlers;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

public interface UserServiceFacadeInterface extends Command {


    public boolean execute(Context context) throws Exception;
}
