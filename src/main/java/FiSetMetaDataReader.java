public interface FiSetMetaDataReader {

    /**
     * Perform a read and return a set of FiSetDummy Meta Data.
     *
     * @return FiSetMetaData object
     *
     * @throws Exception if there is an error reading the data
     */
    FiSetMetaData read() throws Exception;

}
