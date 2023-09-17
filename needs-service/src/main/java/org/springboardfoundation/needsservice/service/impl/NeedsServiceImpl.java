package org.springboardfoundation.needsservice.service.impl;

import org.springboardfoundation.needsservice.service.NeedsService;
import org.springbordfoundation.db.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeedsServiceImpl implements NeedsService {
    @Autowired
    private UserDbService userDbService;
}