package io.papermc.hangar.model.api.project.version;

import io.papermc.hangar.model.api.project.ProjectChannel;
import io.papermc.hangar.model.common.Platform;
import io.papermc.hangar.model.common.projects.ReviewState;
import io.papermc.hangar.model.common.projects.Visibility;
import org.jdbi.v3.core.enums.EnumByOrdinal;
import org.jdbi.v3.core.mapper.Nested;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.time.OffsetDateTime;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class Version extends VersionCompact {

    private final Map<Platform, Set<PluginDependency>> pluginDependencies = new EnumMap<>(Platform.class);
    private final Map<Platform, Set<String>> platformDependencies = new EnumMap<>(Platform.class);
    private final Map<Platform, String> platformDependenciesFormatted = new EnumMap<>(Platform.class);

    public Version(final OffsetDateTime createdAt, @ColumnName("version_string") final String name, final Visibility visibility, final String description, @Nested("vs") final VersionStats stats, @Nested("fi") final FileInfo fileInfo, final String externalUrl, final String author, @EnumByOrdinal final ReviewState reviewState, @Nested("pc") final ProjectChannel channel, final PinnedStatus pinnedStatus, final Long postId) {
        super(createdAt, name, visibility, description, stats, fileInfo, externalUrl, author, reviewState, channel, pinnedStatus, postId);
    }

    public Map<Platform, Set<PluginDependency>> getPluginDependencies() {
        return this.pluginDependencies;
    }

    public Map<Platform, Set<String>> getPlatformDependencies() {
        return this.platformDependencies;
    }

    public Map<Platform, String> getPlatformDependenciesFormatted() {
        return platformDependenciesFormatted;
    }

    @Override
    public String toString() {
        return "Version{" +
            "pluginDependencies=" + this.pluginDependencies +
            ", platformDependencies=" + this.platformDependencies +
            ", platformDependenciesFormatted=" + this.platformDependenciesFormatted +
            "} " + super.toString();
    }
}
