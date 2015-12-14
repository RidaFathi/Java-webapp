package com.sdl.webapp.tridion.versions;

import com.tridion.dynamiccontent.publication.PublicationMapping;

/**
 * This interface is introduced to resolve differences between Web 2013SP1 and Web8
 * and should be removed once 2013SP1 support is dropped.
 * @deprecated should be only used exceptionally, and removed ASAP
 */
public interface TridionVersionsConflictResolver {
    /**
     * Used in com.sdl.webapp.tridion.TridionLocalizationResolver of dxa-tridion-provider.
     */
    PublicationMapping getPublicationMappingFromUrl(String url);
}