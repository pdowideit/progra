public class Certificate{
    private Algorithm algorithm;
    private Pair[] pairs;
    private String signature = null;
    public Certificate(Algorithm alg, Pair ... p){
        algorithm = alg;
        pairs = new Pair[p.length];
        int i = 0;
        for(Pair pair: p){
            pairs[i] = pair;
            i++;
        }
    }

    private Certificate(Algorithm alg, String s, Pair ... p){
        algorithm = alg;
        signature = s;
        pairs = new Pair[p.length];
        int i = 0;
        for(Pair pair: p){
            pairs[i] = pair;
            i++;
        }
    }

    public String get(String k){
        for (Pair p: pairs)   {
            if(p.getKey().equals(k))
                return p.getValue();
        }
        return null;
    }

    public static Certificate fromString(String input){
        input = input.replace(" ","");
        input = input.replace("\'","");
        String[] inputArgs = input.split(";");
        Algorithm a = getAlgorithmFromString(inputArgs[0]);
        String s = inputArgs[2];

        String[]    pairsAsString = inputArgs[1].split(",");
        Pair[] pairs = new Pair[pairsAsString.length];
        int i = 0;
        for(String p: pairsAsString) {
            String keyAndValue[] = p.split(":");
            String key = keyAndValue[0];
            String value = keyAndValue[1];
            pairs[i] = new Pair(key,value);
            i++;
        }
        return new Certificate(a,s,pairs);
    }

    public String getSignedString(String secret) {
        String headerBody = getHeaderBodyString();
        if(signature == null) {
            if (algorithm == Algorithm.HMAC_MD5) {
                signature = Hasher.byteArrayToHex(Hasher.md5Hmac(headerBody, secret));
            }
            if (algorithm == Algorithm.HMAC_SHA1) {
                signature = Hasher.byteArrayToHex(Hasher.sha1Hmac(headerBody, secret));
            }
            if (algorithm == Algorithm.HMAC_SHA256) {
                signature = Hasher.byteArrayToHex(Hasher.sha256Hmac(headerBody, secret));
            }
        }
        return getHeaderBodyString() + "" + signature;
    }

    public boolean validateSignature(String secret){
        if(signature == null)
            return false;
        String headerBody = getHeaderBodyString();
        String valSig = "";
        if (algorithm == Algorithm.HMAC_MD5) {
            valSig = Hasher.byteArrayToHex(Hasher.md5Hmac(headerBody, secret));
        }
        if (algorithm == Algorithm.HMAC_SHA1) {
            valSig = Hasher.byteArrayToHex(Hasher.sha1Hmac(headerBody, secret));
        }
        if (algorithm == Algorithm.HMAC_SHA256) {
            valSig = Hasher.byteArrayToHex(Hasher.sha256Hmac(headerBody, secret));
        }
        return signature.equals(valSig);

    }

    private String getHeaderBodyString(){
        String res = algorithm + ";";
        int i = 0;
        for(Pair p: pairs){
            if(i>0)
                res = res + ",";
            res = res + "\'" + p.getKey() + "\': \'" + p.getValue() + "\'";
            i++;
        }
        return res + ";";
    }

    private static Algorithm getAlgorithmFromString(String s){
        if(s.equals("HMAC_MD5"))
            return Algorithm.HMAC_MD5;
        if(s.equals("HMAC_SHA1"))
            return Algorithm.HMAC_SHA1;
        if(s.equals("HMAC_SHA256"))
            return Algorithm.HMAC_SHA256;
        return null;
    }

}

enum Algorithm
{
    HMAC_MD5,HMAC_SHA1,HMAC_SHA256
}