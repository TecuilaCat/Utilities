package com.github.tecuilacat.utilities.utils;

import com.github.tecuilacat.utilities.annotations.Since;
import com.github.tecuilacat.utilities.annotations.DefaultValue;
import com.github.tecuilacat.utilities.annotations.UtilitiesConfig;
import com.github.tecuilacat.utilities.annotations.UtilityClass;
import com.github.tecuilacat.utilities.exceptions.FileUtilitiesException;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilities surrounding the File clas
 */
@Since(version = "1.0.1")
@UtilityClass(forNativeClass = File.class)
public class FileUtilities {

    @DefaultValue(description = "Functionality is disabled by default")
    private static boolean relativToRootFolderIsEnabled = false;

    private enum ValidTextFileFormats {

        TXT("txt")
        ;

        private String suffix;

        ValidTextFileFormats(String suffix) {
            this.suffix = suffix;
        }

        String getSuffix() {
            return suffix;
        }

        static boolean isValid(String filename) {
            return Arrays.stream(ValidTextFileFormats.values())
                    .anyMatch(v -> StringUtilities.endsWithIgnoreCase(filename, v.getSuffix()));
        }

        static String getOptions() {
            return "[" + Arrays.stream(ValidTextFileFormats.values())
                    .map(ValidTextFileFormats::getSuffix)
                    .collect(Collectors.joining(", ")) + "]";
        }
    }

    /**
     * Disables the usage of a configured default root folder
     */
    @Since(version = "1.0.1")
    @UtilitiesConfig(affects = FileUtilities.class, description = "Disables the configuration of a custom root folder")
    public static void disableRelativeToRootMode() {
        relativToRootFolderIsEnabled = false;
    }

    /**
     * Enables the usage of a configured default root folder
     */
    @Since(version = "1.0.1")
    @UtilitiesConfig(affects = FileUtilities.class, description = "Allows the configuration of a custom root folder")
    public static void enableRelativeToRootMode() {
        relativToRootFolderIsEnabled = true;
    }

    /**
     * Returns the current root folder. If configuration is enabled, it will be empty
     * @return Current root folder
     */
    @Since(version = "1.0.1")
    public static String getRoot() {
        String result = "";
        if (relativToRootFolderIsEnabled) {
            result = DefaultValues.DEFAULT_ROOT_FOLDER;
        }
        return result;
    }

    /**
     * Configures a new root folder from which every further usage will be relative to
     * @param newRoot New root folder
     */
    @Since(version = "1.0.1")
    @UtilitiesConfig(affects = FileUtilities.class, description = "All further usages will have this folder as root folder from which every path will be relative to")
    public void configureRoot(String newRoot) {
        DefaultValues.DEFAULT_ROOT_FOLDER = newRoot;
    }

    /**
     * Tries to create a file. If it already is present, it will simply return the existing file
     * @param filename Name of the file you want to create
     * @return Existing or created file
     * @throws FileUtilitiesException Gets thrown if errors occur
     */
    @Since(version = "1.0.1")
    public static File createFile(final String filename) throws FileUtilitiesException {
        if (filename.isEmpty()) throw new FileUtilitiesException("Cannot create file with empty filename");
        File file;
        try {
            String path = filename;
            if (relativToRootFolderIsEnabled) {
                path = DefaultValues.DEFAULT_ROOT_FOLDER + path;
            }
            file = new File(path);
            if (!fileIsPresent(file)) {
                if (!file.createNewFile()) {
                    throw new FileUtilitiesException("Could not create file " + file.getAbsolutePath() + " even by forcing");
                }
            }
        } catch (Exception e) {
            if (relativToRootFolderIsEnabled) {
                throw new FileUtilitiesException("Could not create file " + filename + " in folder " + DefaultValues.DEFAULT_ROOT_FOLDER);
            } else {
                throw new FileUtilitiesException("Could not create file " + filename);
            }

        }
        return file;
    }

    static void copy(File oldFile, File newFile) throws FileUtilitiesException {
        //TODO
    }

    static byte[] getByteArray(File file) throws FileUtilitiesException {
        //TODO
        return null;
    }

    static void writeToTextFile(File file, String content) throws FileUtilitiesException {
        if (!ValidTextFileFormats.isValid(file.getName())) {
            throw new FileUtilitiesException(file.getName() + " is no text file. Valid formats are: " + ValidTextFileFormats.getOptions());
        }
        //TODO
    }

    static List<String> readFromTextFile(File file) throws FileUtilitiesException {
        if (!ValidTextFileFormats.isValid(file.getName())) {
            throw new FileUtilitiesException(file.getName() + " is no valid text file. Valid formats are: " + ValidTextFileFormats.getOptions());
        }
        //TODO
        return null;
    }

    static boolean deleteFile(File file) throws FileUtilitiesException {
        //TODO
        return false;
    }

    static boolean fileIsPresent(File file) throws FileUtilitiesException {
        //TODO
        return true;
    }

}
