package org.blackc.oauth.security.service;

import java.util.Set;
import org.blackc.oauth.security.dto.ScopeDto;
import org.blackc.oauth.security.entity.OAuthScope;
import org.blackc.oauth.security.mapper.OAuthMapper;
import org.blackc.oauth.security.repository.OAuthScopeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author heyx
 */
@Service
@Transactional(readOnly = true)
public class OAuthScopeService {

    private final OAuthScopeRepository scopeRepository;
    private final OAuthMapper mapper;

    @Autowired
    public OAuthScopeService(OAuthScopeRepository scopeRepository, OAuthMapper mapper) {
        this.scopeRepository = scopeRepository;
        this.mapper = mapper;
    }

    public OAuthScope getScope(Long scopeId) {
        return scopeRepository.findOne(scopeId);
    }

    @Transactional
    public OAuthScope createScope(ScopeDto scopeDto) {
        OAuthScope scope = mapper.mapScopeDtoToEntity(scopeDto);
        return scopeRepository.save(scope);
    }

    @Transactional
    public OAuthScope modifyScope(ScopeDto scopeDto) {
        OAuthScope scope = mapper.mapScopeDtoToEntity(scopeDto);
        return scopeRepository.save(scope);
    }

    @Transactional
    public void deleteScope(Long scopeId) {
        scopeRepository.delete(scopeId);
    }

    public Set<OAuthScope> getScopeByIds(Set<Long> scopeIds) {
        return scopeRepository.findByIdIn(scopeIds);
    }
}
